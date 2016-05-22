package de.chkal.mvctoolbox.core.linkto.impl;

import org.junit.Before;
import org.junit.Test;

import javax.el.ELProcessor;

/**
 * @author Florian Hirsch
 */
public class AlternativeElExpressionsTest {

    private ELProcessor elProcessor;

    @Before
    public void onBefore() {
        elProcessor = new ELProcessor();
        elProcessor.defineBean("toolbox", new AlternativeElExpressions());
        elProcessor.getELManager().addELResolver(new AlternativeElExpressions.LinkToElResolver());
    }

    @Test
    public void test1() {
        System.out.println(elProcessor.eval("toolbox.linkTo.controller.method({'id': 4711, 'foo': 'bar'})"));
        System.out.println(elProcessor.eval("toolbox.linkTo['controller'].method({'id': 4711, 'foo': 'bar'})"));
        System.out.println(elProcessor.eval("toolbox.linkTo.controller.method(4711, 'bar')"));
        System.out.println(elProcessor.eval("toolbox.linkTo['controller'].method(4711, 'bar')"));
    }

}
