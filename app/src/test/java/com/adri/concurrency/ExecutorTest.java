package com.adri.concurrency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExecutorTest {
    @Test
    public void givenNoWaitThenItsDone() {
        Assertions.assertEquals("not done", (new Executor()).execute(0));
    }

    @Test
    public void given500MsWaitThenItsNotDone() {
        Assertions.assertEquals("not done", (new Executor()).execute(500));
    }
}
