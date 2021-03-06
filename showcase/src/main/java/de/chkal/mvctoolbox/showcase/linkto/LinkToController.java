package de.chkal.mvctoolbox.showcase.linkto;

import de.chkal.mvctoolbox.core.linkto.api.LinkTarget;

import javax.mvc.annotation.Controller;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * @author Florian Hirsch
 */
@Controller
@Path("linkto")
public class LinkToController {

	@GET
	@LinkTarget("some-target")
	public String root() {
		return "linkto.jsp";
	}

}
