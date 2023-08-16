package org.example.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Annotation {
}

@Retention(RetentionPolicy.SOURCE)
@interface SourcePolicy {

}

@Retention(RetentionPolicy.CLASS)
@interface ClassPolicy {

}

@Retention(RetentionPolicy.RUNTIME)
@interface RuntimePolicy {

}

class RetentionTest {
    @SourcePolicy
    public void sourcePolicy() {

    }

    @ClassPolicy
    public void classPolicy() {

    }

    @RuntimePolicy
    public void runtimePolicy() {

    }
}
