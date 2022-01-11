import java.util.Stack;
import java.util.Scanner;



public class Main {

    static Stack<String> stack = new Stack<>();

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int cmdNum = 0;
        String cmd = ""; // can be + - q
        boolean done = false;

        do
        {
           displayStack();
           cmd = SafeInput.getRegExString(in,"Enter cmd: + to Push, - to Pop @ to Quit", "[=+-qQ]");

           switch(cmd)
           {
               case "+":
                   cmdNum++;
                   stack.push("Cmd " + cmdNum);
                   //System.out.println(stack);
                   break;
               case "-":
                   if(!stack.empty())
                   {
                       System.out.println("Popping " + stack.peek());
                       stack.pop();
                       //System.out.println(stack);
                   }
                   else
                       System.out.println("Cant pop empty stack!!!");
                   break;
               case "Q":
               case "q":
                   System.out.println("Bye bye!");
                   System.exit(0);
           }
        }while(!done);
    }

    private static void displayStack()
    {
        if(stack.empty())
            System.out.println("\nThe Stack is empty\n\n");
        else
        {
            System.out.println("\n" + stack + "\n\n");
            System.out.println("=========== Top of Stack ===+========");

            for (int dex = stack.size() - 1; dex >= 0; dex--)
            {
                System.out.println("\t" + stack.get(dex));
            }
            System.out.println("======== Bottom of Stack ==========");
        }

    }
}
