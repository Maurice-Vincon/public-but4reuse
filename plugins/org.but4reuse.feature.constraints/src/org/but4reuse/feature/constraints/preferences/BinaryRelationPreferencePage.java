package org.but4reuse.feature.constraints.preferences;

import org.but4reuse.feature.constraints.activator.Activator;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Preference page for binary relations constraints discovery
 * 
 * @author jabier.martinez
 */
public class BinaryRelationPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public static final String REQUIRES = "REQUIRES";
	public static final String EXCLUDES = "EXCLUDES";
	public static final String ONLY_ONE_REASON = "ONLY_ONE_REASON";
	public static final String IGNORE_DISCOVERY_FROM_COMMON_BLOCK = "IGNORE_DISCOVERY_FROM_COMMON_BLOCK";
	public static final String IGNORE_REQUIRES_BLOCKS_NEVER_TOGETHER = "IGNORE_REQUIRES_BLOCKS_NEVER_TOGETHER";
	public static final String IGNORE_EXCLUDES_BLOCKS_TOGETHER_ONCE = "IGNORE_EXCLUDES_BLOCKS_TOGETHER_ONCE";
	
	public BinaryRelationPreferencePage() {
		super(GRID);
		this.setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	/**
	 * Creates the field editors.
	 */
	public void createFieldEditors() {
		BooleanFieldEditor bfeR = new BooleanFieldEditor(REQUIRES, "Requires", getFieldEditorParent());
		addField(bfeR);
		BooleanFieldEditor bfeE = new BooleanFieldEditor(EXCLUDES, "Mutual exclusion", getFieldEditorParent());
		addField(bfeE);
		BooleanFieldEditor bfe = new BooleanFieldEditor(ONLY_ONE_REASON,
				"Find only one reason for the constraint and continue", getFieldEditorParent());
		addField(bfe);
		BooleanFieldEditor bfei = new BooleanFieldEditor(IGNORE_DISCOVERY_FROM_COMMON_BLOCK,
				"Ignore Requires and Excludes from the common block(s)", getFieldEditorParent());
		addField(bfei);
		BooleanFieldEditor bfeir = new BooleanFieldEditor(IGNORE_REQUIRES_BLOCKS_NEVER_TOGETHER,
				"Ignore Requires when the blocks never appeared together", getFieldEditorParent());
		addField(bfeir);
		BooleanFieldEditor bfeie = new BooleanFieldEditor(IGNORE_EXCLUDES_BLOCKS_TOGETHER_ONCE,
				"Ignore Excludes when the blocks appeared together once", getFieldEditorParent());
		addField(bfeie);
	}

	@Override
	public void init(IWorkbench workbench) {
	}

}