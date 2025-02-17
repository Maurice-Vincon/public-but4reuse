package org.but4reuse.tests.utils;

import org.but4reuse.adapters.IElement;
import org.but4reuse.adapters.impl.AbstractElement;

/**
 * Test Element
 * 
 * @author jabier.martinez
 */
public class TestElement extends AbstractElement {

	public static final String PARENT_DEPENDENCYID = "parent";
	
	public int id;

	@Override
	public double similarity(IElement anotherElement) {
		if (anotherElement instanceof TestElement) {
			if (id == ((TestElement) anotherElement).id) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public String getText() {
		return Integer.toString(id);
	}
	
	@Override
	public boolean isContainment(String dependencyId) {
		if (dependencyId.equals(PARENT_DEPENDENCYID)) {
			return true;
		}
		return false;
	}

}
