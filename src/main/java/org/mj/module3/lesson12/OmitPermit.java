package org.mj.module3.lesson12;

// Permits clause is optional, If sealed type and all its subclasses are present in same source file.
sealed class Base /* permits Sub1, Sub2 */ {
}

final class Sub1 extends Base {
}

final class Sub2 extends Base {
}

public class OmitPermit {
}
