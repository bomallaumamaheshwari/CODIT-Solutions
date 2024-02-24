//Task 5 >> Text File Encryption/Decryption


import java.io.*;

public class CaesarCipher {
    // Encrypts text using the Caesar cipher with the given key
    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                char shifted = (char) ('A' + (ch - 'A' + key) % 26);
                result.append(shifted);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Decrypts text using the Caesar cipher with the given key
    public static String decrypt(String text, int key) {
        return encrypt(text, 26 - key); // Decryption is just encryption with the inverse key
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Ask user for input file name
            System.out.print("Enter input file name: ");
            String inputFileName = reader.readLine();

            // Ask user for output file name
            System.out.print("Enter output file name: ");
            String outputFileName = reader.readLine();

            // Ask user for encryption key
            System.out.print("Enter encryption key (an integer): ");
            int key = Integer.parseInt(reader.readLine());

            // Read input file
            BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFileName));
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = inputFileReader.readLine()) != null) {
                text.append(line).append("\n");
            }
            inputFileReader.close();

            // Encrypt text
            String encryptedText = encrypt(text.toString(), key);

            // Write encrypted text to output file
            BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(outputFileName));
            outputFileWriter.write(encryptedText);
            outputFileWriter.close();

            System.out.println("Text encrypted successfully.");

            // Ask user if they want to decrypt the file
            System.out.print("Do you want to decrypt the file? (yes/no): ");
            String choice = reader.readLine();
            if (choice.equalsIgnoreCase("yes")) {
                // Decrypt text
                String decryptedText = decrypt(encryptedText, key);

                // Write decrypted text to a new file
                BufferedWriter decryptedFileWriter = new BufferedWriter(new FileWriter("decrypted_" + outputFileName));
                decryptedFileWriter.write(decryptedText);
                decryptedFileWriter.close();

                System.out.println("Text decrypted successfully.");
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
ajznjax