package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public static MethodSignature parseFunction(String signatureString) {
        signatureString = signatureString.substring(0,signatureString.length() - 1);
        String[] methodSignatureInArr = signatureString.split("\\(");
        String[] signature = methodSignatureInArr[0].split(" ");
        int a = 3;
        String[] signatureBox = new String[a];
        int signatureLength = signature.length;
        for (int i = signatureLength - 1; i >= 0; i--) {
            signatureBox[a - 1] = signature[i];
            a--;
        }

        List<MethodSignature.Argument> argumentsList = new ArrayList<>();
        String[] argumentsArr = methodSignatureInArr[1].split(", ");
        for (String e : argumentsArr) {
            String[] arg = e.split(" ");
            MethodSignature.Argument argument = new MethodSignature.Argument(arg[0], arg[1]);
            argumentsList.add(argument);
        }

        MethodSignature d = new MethodSignature(signatureBox[2]);
        if (signatureBox[0] != null) d.setAccessModifier(signatureBox[0]);
        d.setReturnType(signatureBox[1]);
        d.setMethodName(signatureBox[2]);
        return new MethodSignature(signatureBox[2], argumentsList);
    }

    public static void main(String[] args){
        parseFunction("returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2, argumentType3 argumentName3)");
    }
}
