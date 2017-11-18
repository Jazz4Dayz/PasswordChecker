/* CSCI 111 - ONL 900 - Fall 2017
 * String programming assignment
 * 
 * program asks the user to enter a password and checks
 * if it meets standard password requirements:
 * at least 1 alpha/numeric char & at least 1 special char
 * 
 * @author
 * last edited November 17, 2017
 */

package createandverifypass;
import java.util.Scanner;

public class CreateAndVerifyPass 
{

    public static void main(String[] args)
    {
        String password1, password2;
        boolean pEquals, pAlphaMet = false, pNumMet = false, 
                pSpecialMet = false, pCharOccMet = false,
                pNoSpaceMet = false, pStartsQuestExpMet = false,
                pLengthMet = false;
        
        Scanner kb = new Scanner(System.in);
        
        do
        {
            System.out.println("\nPassword requirements include:"
                    + "\nat least 1 letter"
                    + "\nat least 1 number"
                    + "\nat least 1 special character (i.e. @ # $)"
                    + "\nno spaces"
                    + "\nmust not start with \"!\" or \"?\" ");

            System.out.print("Please enter a password you would like to use: ");
            password1 = kb.nextLine();

            System.out.print("Please enter one more time:");
            password2 = kb.nextLine();

            pEquals = PassMatch(password1, password2);
            if (pEquals == false)
            {
                System.out.println("Passwords do not match.");
            }

            pAlphaMet = PAlphaCheck(password1);
            if (pAlphaMet == false)
            {
                System.out.println("You're missing at least "
                        + "1 alphabetic letter.");
            }

            pNumMet = PNumCheck (password1);
            if (pNumMet == false)
            {
                System.out.println("You're missing at least "
                        + "1 number.");
            }

            pSpecialMet = PSpecialCheck (password1);
            if (pSpecialMet == false)
            {
                System.out.println("You're missing at least "
                        + "1 special character");
            }

            pStartsQuestExpMet = PQuestExcCheck (password1);
            if (pStartsQuestExpMet)
            {
                System.out.println("You cannot include an "
                        + "\"!\" or a \"?\" as the first character "
                        + " of your password.");
            }
            
            pNoSpaceMet = PSpaceCheck (password1);
            if (pNoSpaceMet == false)
            {
                System.out.println("You must not include any spaces.");
            }
            
            pCharOccMet = PCharOccMet(password1);
            if (pCharOccMet == false)
            {
                System.out.println("You can't repeat the same character "
                        + "more than twice.");
            }
            
            pLengthMet = PLengthCheck (password1);
            if (pLengthMet == false)
            {
                System.out.println("Your password must be at least "
                        + "8 characters long.");
            }
        
        }while(pEquals == false || pAlphaMet == false || pNumMet == false ||
                pSpecialMet == false || pCharOccMet == false ||
                pStartsQuestExpMet || pLengthMet == false);
        
        System.out.println("Password accepted!");
    }
    
    static boolean PassMatch (String p1, String p2)
    {
        boolean equal = false;
        boolean pe = p1.equals(p2);
        
        if(pe == true)
        {
            equal = true;
        }
        
        return equal;
    }
    
    static boolean PAlphaCheck (String p)
    {
        boolean hasAlpha = false;
        char c;
        
        for (int i = 0; i<p.length(); i++)
        {
            c = p.charAt(i);
            while (Character.isLetter(c))
            {
                hasAlpha = true;
                break;
            }
        }
        
        return hasAlpha;
    }
    
    static boolean PNumCheck(String p)
    {
        boolean hasNum = false;
        char c;
        
        for (int i = 0; i<p.length(); i++)
        {
            c = p.charAt(i);
            while (Character.isDigit(c))
            {
                hasNum = true;
                break;
            }
        }
        
        return hasNum;
    }
    
    static boolean PSpecialCheck (String p)
    {
        boolean hasSpec = false;
        
        for (int i = 0; i<p.length(); i++)
        {
            char c = p.charAt(i);
            
            if(!Character.isLetter(c) && !Character.isDigit(c))
            {
                hasSpec = true;
            }
        }
            
        return hasSpec;
    }
    
    static boolean PSpaceCheck (String p)
    {
        boolean hasNoWhitespacepace = true;
        char c;
        
        for (int i = 0; i<p.length(); i++)
        {
            c = p.charAt(i);
            while (Character.isWhitespace(c))
            {
                hasNoWhitespacepace = false;
                break;
            }
        }
        
        return hasNoWhitespacepace;
    }
    
    static boolean PQuestExcCheck (String p) // checks for ? and ! as first char
    {
        boolean StartsQuestExp = false;
        
        while (p.startsWith("!") | p.startsWith("?"))
        {
            StartsQuestExp = true;
            break;
        }
            
        return StartsQuestExp;
    }
    
    static boolean PCharOccMet (String p)
    {
        boolean repeatExcess = true;

        for(int i = 0; i<p.length()-1; i++)
        {
            char c = p.charAt(i);
                    
            if(p.charAt(i) == p.charAt(i+1) && p.charAt(i+1) == p.charAt(i+2))
            {
                repeatExcess = false; //return true as it has 3 consecutive same character
            }
        }
        
        return repeatExcess;
    }
    
    static boolean PLengthCheck (String p)
    {
        boolean longEnough = true;
        
        if (p.length()<8)
        {
            longEnough = false;
        }
        
        return longEnough;
    }
}
