package com.nitish.qa.selectionstrategy;

import org.testng.IMethodInstance;

public interface TestSelectionStrategy {

    boolean shouldRun(IMethodInstance methodInstance, String filterValue);

}
