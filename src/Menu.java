/*************************************************************************************************
 * Nicholas Mel
 * Description: The Menu class displays a menu of choices to a user
 * and performs the chosen task. It will keep asking a user to
 * enter the next choice until the choice of 'Q' (Quit) is entered.
 ********************************************************************************************/

import java.io.*;

public class Menu {

    public static void main(String[] args) throws NotSerializableException {
        char input;
        String city, state, zipInput, text;
        int zipcode;
        boolean operation = false;
        int operation2 = 0;
        String line;
        String filename;

        PostOffice office1 = new PostOffice();

        try {
            printMenu();
            // create a BufferedReader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader (System.in);
            BufferedReader stdin = new BufferedReader (isr);

            do {
                System.out.print("What action would you like to perform?\n");
                line = stdin.readLine().trim();
                input = Character.toUpperCase(line.charAt(0));

                if (line.length() == 1) {
                    switch (input) {
                        case 'A':   //Add Zipcode
                            try {
                                System.out.print("Please enter a city to add:\n");
                                city = stdin.readLine().trim();
                                System.out.print("Please enter its state to add:\n");
                                state = stdin.readLine().trim();
                                System.out.print("Please enter its zipcode to add:\n");
                                zipInput = stdin.readLine().trim();
                                zipcode = Integer.parseInt(zipInput);
                                operation = office1.addZipInfo(city, state, zipcode);
                                if (operation = true) {
                                    System.out.print("zipcode added\n");
                                } else {
                                    System.out.print("zipcode exists\n");
                                }
                            }
                            catch(NumberFormatException e) {
                                System.out.println("Please enter an integer for zipcode. Zipcode not added\n");
                            }
                            break;

                        case 'D':  //Search by Zipcode
                            try {
                                System.out.print("Please enter zipcode to search:\n");
                                zipInput = stdin.readLine().trim();
                                zipcode = Integer.parseInt(zipInput);
                                operation2 = office1.zipcodeExists(zipcode);

                                if (operation2 > -1) {
                                    System.out.print("zipcode found\n");
                                }
                                else {
                                    System.out.print("zipcode not found\n");
                                }
                            }
                            catch(NumberFormatException e) {
                                System.out.println("Please enter an integer for zipcode. Zipcode not found\n");
                            }
                            break;

                        case 'E':  //Search by City and State
                            System.out.print("Please enter a city to search:\n");
                            city = stdin.readLine().trim();
                            System.out.print("Please enter a state to search:\n");
                            state = stdin.readLine().trim();
                            operation2 = office1.cityStateExists(city, state);

                            if (operation2 > -1) {
                                System.out.print("city and state found\n");
                            }
                            else {
                                System.out.print("city and state not found\n");
                            }
                            break;

                        case 'L':   //List Zipcodes
                            System.out.print(office1.listZipcode() + "\n");
                            break;

                        case 'O':  // Sort by Zipcode
                            office1.sortByZipcode();
                            System.out.print("sorted by zipcode\n");
                            break;

                        case 'P':  // Sort by States and Cities
                            office1.sortByCityState();
                            System.out.print("sorted by states and cities\n");
                            break;

                        case 'Q':   //Quit
                            break;

                        case 'R':  //Remove by Zipcode
                            try {
                                System.out.print("Please enter zipcode to remove:\n");
                                zipInput = stdin.readLine().trim();
                                zipcode = Integer.parseInt(zipInput);
                                operation = office1.removeZipcode(zipcode);

                                if (operation) {
                                    System.out.print("zipcode removed\n");
                                }
                                else {
                                    System.out.print("zipcode not found\n");
                                }
                            }
                            catch(NumberFormatException e) {
                                System.out.println("Please enter an integer for zipcode. Zipcode not removed\n");
                            }
                            break;

                        case 'S':  //Remove by State and City
                            System.out.print("Please enter a city to remove:\n");
                            city = stdin.readLine().trim();
                            System.out.print("Please enter a state to remove:\n");
                            state = stdin.readLine().trim();
                            operation = office1.removeCityState(city, state);

                            if (operation) {
                                System.out.print("city and state removed\n");
                            }
                            else {
                                System.out.print("city and state not found\n");
                            }
                            break;

                        case 'T':  //Close PostOffice
                            office1.closePostOffice();
                            System.out.print("post office closed\n");
                            break;

                        case 'U':  //Write Text to a File
                            System.out.print("Please enter a file name to write:\n");
                            filename = stdin.readLine().trim();
                            System.out.print("Please enter a string to write in the file:\n");
                            text = stdin.readLine().trim();
                            FileWriter fw = new FileWriter (filename);
                            BufferedWriter bw = new BufferedWriter (fw);
                            PrintWriter outFile = new PrintWriter (bw);
                            outFile.write(text);
                            outFile.close();
                            if(operation) {
                                System.out.print(filename + " was written\n");
                            }
                            break;

                        case 'V':  //Read Text from a File
                            System.out.print("Please enter a file name to read:\n");
                            filename = stdin.readLine().trim();

                            try {
                                FileReader fr = new FileReader (filename);
                                BufferedReader inFile = new BufferedReader (fr);
                                if (operation) {
                                    System.out.println(filename + " was read\n");
                                }
                                //Then read the only the first line of the file
                                System.out.println("The first line of the file is:\n");
                                System.out.println(inFile);
                            }
                            catch(FileNotFoundException e) {
                                System.out.println(filename + " was not found\n");
                            }
                            break;

                        case 'W':  //Serialize PostOffice to a File
                            System.out.print("Please enter a file name to write:\n");
                            filename = stdin.readLine().trim();

                            try {
                                FileOutputStream fo = new FileOutputStream(filename);
                                ObjectOutputStream os = new ObjectOutputStream(fo);
                                ObjectOutputStream os2 = new ObjectOutputStream(os);
                                os2.writeObject(office1);
                                os2.close();
                            }
                            catch(NotSerializableException e) {
                                if(operation) {
                                    System.out.println(filename + " was read\n");
                                }
                            }
                            break;

                        case 'X':  //Deserialize PostOffice from a File
                            System.out.print("Please enter a file name to read:\n");
                            filename = stdin.readLine().trim();
                            FileInputStream fi = new FileInputStream(filename);
                            ObjectInputStream oi = new ObjectInputStream(fi);
                            Object anyObject = null;
                            try {
                                anyObject = oi.readObject( );
                            }
                            catch(ClassNotFoundException e) {
                                System.out.println(e);
                            }
                            office1 = (PostOffice)anyObject;
                            if(operation) {
                                System.out.println(filename + " was read\n");
                            }
                            oi.close();
                            break;
                        case '?':   //Display Menu
                            printMenu();
                            break;
                        default:
                            System.out.print("Unknown action\n");
                            break;
                    }
                }
                else {
                    System.out.print("Unknown action\n");
                }
            }
            while (input != 'Q' || line.length() != 1);
        }
        catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
    }

    public static void printMenu() {
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd Zipcode\n" +
                "D\t\tSearch for Zipcode\n" +
                "E\t\tSearch for City and State\n" +
                "L\t\tList Zipcode\n" +
                "O\t\tSort by Zipcode\n" +
                "P\t\tSort by City and State\n" +
                "R\t\tRemove by Zipcode\n" +
                "S\t\tRemove by City and State\n" +
                "T\t\tClose PostOffice\n" +
                "U\t\tWrite Text to File\n" +
                "V\t\tRead Text from File\n" +
                "W\t\tSerialize PostOffice to File\n" +
                "X\t\tDeserialize PostOffice from File\n" +
                "?\t\tDisplay Help\n\n" +
                "Q\t\tQuit\n");
    }
}
