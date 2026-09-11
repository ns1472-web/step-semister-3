class AccessChecker {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
            return fieldModifier.equals("protected") || fieldModifier.equals("public") ? "ALLOWED" : "DENIED";
        }
        if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {
            return fieldModifier.equals("public") ? "ALLOWED" : "DENIED";
        }
        if (fieldModifier.equals("private")) {
            return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
        }
        if (fieldModifier.equals("default")) {
            return accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";
        }
        if (fieldModifier.equals("protected")) {
            return accessorContext.equals("DIFFERENT_PACKAGE") ? "DENIED" : "ALLOWED";
        }
        return "ALLOWED";
    }
}
public class w5q2 {
    public static void main(String[] args) {
        String firstResult = AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE");
        String secondResult = AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE");
        System.out.println(firstResult);
        System.out.println(secondResult);
    }
}