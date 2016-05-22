package de.chkal.mvctoolbox.core.linkto.impl;

import javax.el.ELContext;
import javax.el.ELResolver;
import java.beans.FeatureDescriptor;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Florian Hirsch
 */
public class AlternativeElExpressions {

    public static class LinkedMethodExpression {

        public final String key;

        public LinkedMethodExpression(String key) {
            this.key = key;
        }

    }

    public static class LinkToElResolver extends ELResolver {

        private static final String LINK_TO = "linkTo";

        @Override
        public Object getValue(ELContext context, Object base, Object property) {
            if (LINK_TO.equals(property)) {
                context.setPropertyResolved(true);
                return new LinkedMethodExpression(LINK_TO);
            }
            if (property != null && base != null && base.getClass() == LinkedMethodExpression.class) {
                context.setPropertyResolved(true);
                return new LinkedMethodExpression(property.toString());
            }
            return null;
        }

        @Override
        public Class<?> getType(ELContext context, Object base, Object property) {
            if (LINK_TO.equals(property)) {
                context.setPropertyResolved(true);
                return LinkedMethodExpression.class;
            }
            return null;
        }

        @Override
        public Object invoke(ELContext context, Object base, Object method, Class<?>[] paramTypes, Object[] params) {
            if (base == null || base.getClass() != LinkedMethodExpression.class) {
                return null;
            }
            context.setPropertyResolved(base, method);
            return String.format("controller: %s, method: %s, params: %s", ((LinkedMethodExpression) base).key, method.toString(), Arrays.asList(params));
        }

        @Override
        public void setValue(ELContext context, Object base, Object property, Object value) {

        }

        @Override
        public boolean isReadOnly(ELContext context, Object base, Object property) {
            return true;
        }

        @Override
        public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext context, Object base) {
            return null;
        }

        @Override
        public Class<?> getCommonPropertyType(ELContext context, Object base) {
            return null;
        }

    }

}
