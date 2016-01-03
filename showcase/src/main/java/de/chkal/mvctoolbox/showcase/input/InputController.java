package de.chkal.mvctoolbox.showcase.input;

import de.chkal.mvctoolbox.core.message.Messages;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Controller
@Path("/input")
public class InputController {

  @Inject
  private Models models;

  @Inject
  private Messages messages;

  @Inject
  private BindingResult bindingResult;

  @GET
  public String get() {

    InputForm form = new InputForm();
    form.setText1(null);
    form.setText2("Some initial value");

    models.put("form", form);
    return "input.jsp";

  }

  @POST
  public String post(@BeanParam @Valid InputForm form) {

    if (bindingResult.isFailed()) {
      messages.add(bindingResult);
      models.put("form", form);
      return "input.jsp";
    }

    messages.add("Text #1: " + form.getText1());
    messages.add("Text #2: " + form.getText2());
    return "redirect:/input";

  }

}