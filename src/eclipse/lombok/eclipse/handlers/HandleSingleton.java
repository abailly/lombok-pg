/*
 * Copyright © 2010-2011 Philipp Eichhorn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package lombok.eclipse.handlers;

import lombok.*;
import lombok.Singleton.Style;
import lombok.core.AnnotationValues;
import lombok.core.handlers.SingletonHandler;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.ast.EclipseMethod;
import lombok.eclipse.handlers.ast.EclipseType;

import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.mangosdk.spi.ProviderFor;

/**
 * Handles the {@link Singleton} annotation for eclipse.
 */
@ProviderFor(EclipseAnnotationHandler.class)
public class HandleSingleton extends EclipseAnnotationHandler<Singleton> {

	@Override
	public void handle(final AnnotationValues<Singleton> annotation, final Annotation source, final EclipseNode annotationNode) {
		// TODO FIXME @Singleton(style=HOLDER) does not work for eclipse
		// remove warning and cleanup once bug is dead and buried
		final Style style = annotation.getInstance().style();
		if (Style.HOLDER == style) {
			annotationNode.addWarning(String.format("Lombok-pg Issue #68: The Singleton style %s is currently not working for eclipse. We are working on it.", style));
		}
		new SingletonHandler<EclipseType, EclipseMethod>(EclipseType.typeOf(annotationNode, source), annotationNode).handle(style);
	}
}
