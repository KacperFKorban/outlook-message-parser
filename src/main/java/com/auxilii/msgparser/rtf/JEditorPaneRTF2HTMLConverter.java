/*
 * msgparser - http://auxilii.com/msgparser
 * Copyright (C) 2013  Roman Kurmanowytsch
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package com.auxilii.msgparser.rtf;

import javax.swing.*;
import javax.swing.text.EditorKit;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class JEditorPaneRTF2HTMLConverter implements RTF2HTMLConverter {

	public String rtf2html(String rtf) throws Exception {
		JEditorPane p = new JEditorPane();
		p.setContentType("text/rtf");
		EditorKit kitRtf = p.getEditorKitForContentType("text/rtf");
		try {
			StringReader rtfReader = new StringReader(rtf);
			kitRtf.read(rtfReader, p.getDocument(), 0);
			EditorKit kitHtml = p.getEditorKitForContentType("text/html");
			Writer writer = new StringWriter();
			kitHtml.write(writer, p.getDocument(), 0, p.getDocument().getLength());
			return writer.toString();
		} catch (Exception e) {
			throw new Exception("Could not convert RTF to HTML.", e);
		}
	}

}