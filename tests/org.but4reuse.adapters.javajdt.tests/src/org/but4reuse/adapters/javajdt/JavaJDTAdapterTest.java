package org.but4reuse.adapters.javajdt;

import java.io.File;
import java.net.URI;
import java.util.List;

import org.but4reuse.adapters.IAdapter;
import org.but4reuse.adapters.IElement;
import org.but4reuse.adapters.javajdt.elements.CompilationUnitElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Test;
import org.junit.Assert;

/**
 * Run As JUnit Plug-in test
 * 
 * @author jabier.martinez
 */
public class JavaJDTAdapterTest {

	@Test
	public void basicTest() {
		IAdapter jdtAdapter = new JavaJDTAdapter();
		URI uri = new File("data/simpleExample").toURI();
		List<IElement> elements = jdtAdapter.adapt(uri, new NullProgressMonitor());
		// Check that we found some elements
		Assert.assertEquals(false, elements.isEmpty());
		// Check that there are 3 compilation units
		int numberOfCUs = 0;
		for (IElement element : elements) {
			if (element instanceof CompilationUnitElement) {
				numberOfCUs++;
			}
		}
		Assert.assertEquals(3, numberOfCUs);
	}
}
