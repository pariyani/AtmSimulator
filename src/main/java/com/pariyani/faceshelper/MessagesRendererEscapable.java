package com.pariyani.faceshelper;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.context.ResponseWriterWrapper;
import javax.faces.render.FacesRenderer;

import com.sun.faces.renderkit.html_basic.MessagesRenderer;

/**
 * Here we ovveride the MessagesRenderer class from JSF API as it doesn't
 * support escaping functionality. For example: if have a message with HTML and
 * you want to display it as html then you can set the attribute escape to false
 * and it wont encode the string.
 * 
 * @author imran
 */
@FacesRenderer(componentFamily = "javax.faces.Messages", rendererType = "javax.faces.Messages")
public class MessagesRendererEscapable extends MessagesRenderer {

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		final ResponseWriter originalResponseWriter = context.getResponseWriter();
		context.setResponseWriter(new ResponseWriterWrapper() {

			@Override
			public ResponseWriter getWrapped() {
				return originalResponseWriter;
			}

			@Override
			public void writeText(Object text, UIComponent component, String property) throws IOException {
				String string = String.valueOf(text);
				String escape = (String) component.getAttributes().get("escape");
				if (escape != null && !Boolean.valueOf(escape))
					super.write(string);
				else
					super.writeText(string, component, property);
			}
		});

		super.encodeEnd(context, component);
		context.setResponseWriter(originalResponseWriter);
	}
}
