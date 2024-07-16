import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RegExp {
    
    public static boolean isPalindrome(String MainStr) {
        int start = 0;
        int end = MainStr.length() - 1;
        while (start < end) {
            if (!Character.isLetter(MainStr.charAt(start)) || !Character.isLetter(MainStr.charAt(end))) { 
                if (MainStr.charAt(start) == MainStr.charAt(end)) { 
                    start++;
                    end--;
                }
                else {
                    return false;
                }
            }
            else {
                if (Character.toLowerCase(MainStr.charAt(start)) != Character.toLowerCase(MainStr.charAt(end))) { 
                    return false;
                }
                else { 
                    start++;
                    end--;
                }
            }
        }
        return true;
    }

    public static boolean ContainsStr1(String str1, String MainStr) {
        int SubLength = str1.length();
        int MainLength = MainStr.length();
        if (SubLength > MainLength) { 
            return false;
        }
        for (int i=0;i<=MainLength-SubLength;i++) {
            int j;
            if (Character.toLowerCase(MainStr.charAt(i)) == Character.toLowerCase(str1.charAt(0))) {
                for (j=1;j<SubLength;j++) {
                    if (Character.toLowerCase(MainStr.charAt(i+j)) != Character.toLowerCase(str1.charAt(j))) {
                        break;
                    }
                }
                if (j == SubLength) { 
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean SubStringOccurences(String MainStr,String str2,int n) {
        int count = 0;
        int MainLength = MainStr.length();
        int SubLength = str2.length();
        for (int i = 0;i<=MainLength - SubLength;i++) {
            boolean found = true;
            for (int j = 0;j<SubLength;j++) {
                if (Character.toLowerCase(MainStr.charAt(i+j)) != Character.toLowerCase(str2.charAt(j))) {
                    found = false;
                    break;
                }
            }
            if (found) {
                count++;
            }
        }
        if (count == n || count > n) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean SubstringMatch(String MainStr) {
        boolean foundA = false;
        boolean foundB = false;
        int countB = 0;
        for (int i = 0; i < MainStr.length(); i++) {
            if (!foundA) {
                if (MainStr.charAt(i) == 'A' || MainStr.charAt(i) == 'a') {
                    foundA = true;
                }
            }
            else if (foundA) {
                if (!foundB) {
                    if (MainStr.charAt(i) == 'b' || MainStr.charAt(i) == 'B') {
                        foundB = true;
                        countB++;
                    }
                }
                else if (foundB) {
                    if (countB < 2) {
                        if (MainStr.charAt(i-1) == 'b' || MainStr.charAt(i-1) == 'B') {
                            if (MainStr.charAt(i) == 'b' || MainStr.charAt(i) == 'B') { 
                                countB++;
                            }
                        }
                        else {
                            if (MainStr.charAt(i) == 'b' || MainStr.charAt(i) == 'B')
                            {
                             countB = 0;
                             countB++;
                            }
                        }
                    }
                    else if (countB >= 2) {
                        return true;
                    }
                }
            }
        }
        if (countB >= 2) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        String file = args[0];
        String str1 = args[1];
        String str2 = args[2];
        int s2Count = Integer.parseInt(args[3]);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if(isPalindrome(line)) {
                    System.out.print("Y");
                }
                else {
                    System.out.print("N");
                }
                System.out.print(",");

                if(ContainsStr1(str1, line)) {
                    System.out.print("Y");
                }
                else {
                    System.out.print("N");
                }
                System.out.print(",");

                if(SubStringOccurences(line, str2, s2Count)) {
                    System.out.print("Y");
                }
                else {
                    System.out.print("N");
                }
                System.out.print(",");

                if(SubstringMatch(line)) {
                    System.out.print("Y");
                }
                else {
                    System.out.print("N");
                }

                System.out.println();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "RegExp []";
    }
}