/*
 * Copyright © 2011 Philipp Eichhorn
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
package lombok;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.SOURCE;

import java.lang.annotation.*;

/**
 * Helps defining complex {@link Rethrow} statements.
 * <p>
 * With lombok:
 * 
 * <pre>
 * &#64;Rethrows({
 *   &#64;Rethrow(IOException.class),
 *   &#64;Rethrow(value=NullPointerException.class,as=IllegalArgumentException.class)
 * })
 * void testMethod(Object arg) {
 *   // do something
 * }
 * 
 * void testMethod() throw IOException as RuntimeException, NullPointerException as IllegalArgumentException {
 *   // do something
 * }
 * </pre>
 * 
 * Vanilla Java:
 * 
 * <pre>
 * void testMethod(Object arg) {
 * 	try {
 * 		// do something
 * 	} catch (IOException e1) {
 * 		throw new RuntimeException(e1);
 * 	} catch (NullPointerException e2) {
 * 		throw new IllegalArgumentException(e2);
 * 	}
 * }
 * </pre>
 */
@Target(METHOD)
@Retention(SOURCE)
public @interface Rethrows {
	Rethrow[] value();
}
