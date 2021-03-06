package de.chkal.mvctoolbox.core.linkto.impl;

import de.chkal.mvctoolbox.core.linkto.api.LinkTarget;

import javax.mvc.annotation.Controller;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * <p>Encapsulates controllers for LinkTo tests.</p>
 *
 * @author Florian Hirsch
 */
public class LinkToTestControllers {

	@Controller
	@Path("some")
	static class SomeController extends SuperController {

		@GET
		public String root() {
			return null;
		}

		@GET
		@Path("path")
		public String path() {
			return null;
		}

		@Override
		public String parent() {
			return null;
		}

	}

	static class SuperController {

		@GET
		@Path("parent")
		public String parent() {
			return null;
		}

	}

	interface ControllerInterface {

		@GET
		@Path("show")
		String show();

	}

	@Controller
	@Path("implementation")
	static class ControllerImplementation implements ControllerInterface {

		@Override
		public String show() {
			return null;
		}

	}

	@Controller
	@Path("params")
	static class ParamsController {

		@GET
		public String root() {
			return null;
		}

		@GET
		@Path("path/{p1}/{p2}")
		public String pathParams(@PathParam("p1") String p1, @PathParam("p2") long p2) {
			return null;
		}

		@GET
		@Path("query")
		public String queryParams(@QueryParam("q1") String q1, @QueryParam("q2") long q2) {
			return null;
		}

		@GET
		@Path("matrix")
		public String matrixParams(@MatrixParam("m1") String m1, @MatrixParam("m2") long m2) {
			return null;
		}

	}

	@Controller
	@Path("fields/{p1}/{p2}/{p3}")
	static class FieldsController {

		@PathParam("p1")
		private String p1;

		private String p2;

		private String p3;

		@QueryParam("q1")
		private String q1;

		private String q2;

		private String q3;

		@MatrixParam("m1")
		private String m1;

		private String m2;

		private String m3;

		@GET
		public String root() {
			return null;
		}

		public String getP1() {
			return p1;
		}

		public void setP1(String p1) {
			this.p1 = p1;
		}

		@PathParam("p2")
		public String getP2() {
			return p2;
		}

		public void setP2(String p2) {
			this.p2 = p2;
		}

		public String getP3() {
			return p3;
		}

		@PathParam("p3")
		public void setP3(String p3) {
			this.p3 = p3;
		}

		public String getQ1() {
			return q1;
		}

		public void setQ1(String q1) {
			this.q1 = q1;
		}

		@QueryParam("q2")
		public String getQ2() {
			return q2;
		}

		public void setQ2(String q2) {
			this.q2 = q2;
		}

		public String getQ3() {
			return q3;
		}

		@QueryParam("q3")
		public void setQ3(String q3) {
			this.q3 = q3;
		}

		public String getM1() {
			return m1;
		}

		public void setM1(String m1) {
			this.m1 = m1;
		}

		@MatrixParam("m2")
		public String getM2() {
			return m2;
		}

		public void setM2(String m2) {
			this.m2 = m2;
		}

		public String getM3() {
			return m3;
		}

		@MatrixParam("m3")
		public void setM3(String m3) {
			this.m3 = m3;
		}

	}

	@Controller
	@Path("bean")
	static class BeanParamController {

		@GET
		@Path("{p}")
		public String bean(@BeanParam BeanParams params) {
			return null;
		}

	}

	static class BeanParams {

		@PathParam("p")
		private String p;

		@QueryParam("q")
		private String q;

		@MatrixParam("m")
		private String m;

	}

	@Controller
	@Path("target")
	static class TargetController {

		@GET
		@LinkTarget("target-method")
		public String getRoot() {
			return null;
		}

		@POST
		@LinkTarget("target-method")
		public String postRoot() {
			return null;
		}

	}

	@Controller
	@Path("ambiguous")
	static class AmbiguousController {

		@GET
		@LinkTarget("target-method")
		public String getAmbiguousRoot() {
			return null;
		}

	}

}
