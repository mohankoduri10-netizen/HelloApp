import java.util.HashMap;
import java.util.Map;

public class OopsBannerApp {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("          OOPS BANNER APP EVOLUTION               ");
        System.out.println("==================================================\n");

        // ---------------------------------------------------------------------
        // STAGE 1: Simple Console Display
        // ---------------------------------------------------------------------
        System.out.println("--- STAGE 1: Simple Console Display ---");
        displayStage1();
        System.out.println();

        // ---------------------------------------------------------------------
        // STAGE 2: Banner Format using Space and * (Hardcoded)
        // ---------------------------------------------------------------------
        System.out.println("--- STAGE 2: Banner Format (Hardcoded) ---");
        displayStage2();
        System.out.println();

        // ---------------------------------------------------------------------
        // STAGE 3: Refactoring to Modular Functions
        // ---------------------------------------------------------------------
        System.out.println("--- STAGE 3: Modular Functions ---");
        displayStage3("OOPS");
        System.out.println();

        // ---------------------------------------------------------------------
        // STAGE 4: Class-Based Pattern Storage
        // ---------------------------------------------------------------------
        System.out.println("--- STAGE 4: Class-Based Pattern Storage ---");
        displayStage4("OOPS");
        System.out.println();

        // ---------------------------------------------------------------------
        // STAGE 5: Map-Based Dynamic Lookup
        // ---------------------------------------------------------------------
        System.out.println("--- STAGE 5: Map-Based Dynamic Lookup ---");
        displayStage5("OOPS");
        System.out.println();
    }

    // =========================================================================
    // STAGE 1: Print simple string
    // =========================================================================
    public static void displayStage1() {
        System.out.println("OOPS");
    }

    // =========================================================================
    // STAGE 2: Hardcoded printing row-by-row
    // =========================================================================
    public static void displayStage2() {
        System.out.println("  ***    ***   ****   **** ");
        System.out.println(" *   *  *   *  *   * *     ");
        System.out.println(" *   *  *   *  ****   ***  ");
        System.out.println(" *   *  *   *  *         * ");
        System.out.println("  ***    ***   *     ****  ");
    }

    // =========================================================================
    // STAGE 3: Modular Functions
    // =========================================================================
    public static void displayStage3(String text) {
        for (int i = 0; i < 5; i++) {
            StringBuilder rowBuilder = new StringBuilder();
            for (char c : text.toCharArray()) {
                rowBuilder.append(getLetterRowStage3(c, i)).append("  ");
            }
            System.out.println(rowBuilder.toString());
        }
    }

    private static String getLetterRowStage3(char letter, int rowIndex) {
        switch (Character.toUpperCase(letter)) {
            case 'O':
                String[] oPattern = {
                    " *** ",
                    "*   *",
                    "*   *",
                    "*   *",
                    " *** "
                };
                return oPattern[rowIndex];
            case 'P':
                String[] pPattern = {
                    "**** ",
                    "*   *",
                    "**** ",
                    "*    ",
                    "*    "
                };
                return pPattern[rowIndex];
            case 'S':
                String[] sPattern = {
                    " ****",
                    "*    ",
                    " *** ",
                    "    *",
                    "**** "
                };
                return sPattern[rowIndex];
            default:
                return "     ";
        }
    }

    // =========================================================================
    // STAGE 4: Class-Based Design
    // =========================================================================
    static class LetterPattern {
        private final char character;
        private final String[] rows;

        public LetterPattern(char character, String[] rows) {
            this.character = character;
            this.rows = rows;
        }

        public String getRow(int index) {
            if (index >= 0 && index < rows.length) {
                return rows[index];
            }
            return " ".repeat(rows[0].length());
        }

        public int getHeight() {
            return rows.length;
        }
    }

    public static void displayStage4(String text) {
        LetterPattern letterO = new LetterPattern('O', new String[]{
            " *** ",
            "*   *",
            "*   *",
            "*   *",
            " *** "
        });
        
        LetterPattern letterP = new LetterPattern('P', new String[]{
            "**** ",
            "*   *",
            "**** ",
            "*    ",
            "*    "
        });

        LetterPattern letterS = new LetterPattern('S', new String[]{
            " ****",
            "*    ",
            " *** ",
            "    *",
            "**** "
        });

        for (int i = 0; i < 5; i++) {
            StringBuilder rowBuilder = new StringBuilder();
            for (char c : text.toCharArray()) {
                LetterPattern selectedPattern;
                switch (Character.toUpperCase(c)) {
                    case 'O':
                        selectedPattern = letterO;
                        break;
                    case 'P':
                        selectedPattern = letterP;
                        break;
                    case 'S':
                        selectedPattern = letterS;
                        break;
                    default:
                        selectedPattern = new LetterPattern(' ', new String[]{" ", " ", " ", " ", " "});
                }
                rowBuilder.append(selectedPattern.getRow(i)).append("  ");
            }
            System.out.println(rowBuilder.toString());
        }
    }

    // =========================================================================
    // STAGE 5: Map-Based Dynamic Lookup
    // =========================================================================
    public static void displayStage5(String text) {
        Map<Character, LetterPattern> patternMap = new HashMap<>();
        
        patternMap.put('O', new LetterPattern('O', new String[]{
            " *** ",
            "*   *",
            "*   *",
            "*   *",
            " *** "
        }));
        
        patternMap.put('P', new LetterPattern('P', new String[]{
            "**** ",
            "*   *",
            "**** ",
            "*    ",
            "*    "
        }));
        
        patternMap.put('S', new LetterPattern('S', new String[]{
            " ****",
            "*    ",
            " *** ",
            "    *",
            "**** "
        }));

        int bannerHeight = 5;
        
        for (int i = 0; i < bannerHeight; i++) {
            StringBuilder rowBuilder = new StringBuilder();
            for (char c : text.toUpperCase().toCharArray()) {
                LetterPattern pattern = patternMap.get(c);
                if (pattern != null) {
                    rowBuilder.append(pattern.getRow(i));
                } else {
                    rowBuilder.append("     ");
                }
                rowBuilder.append("  ");
            }
            System.out.println(rowBuilder.toString());
        }
    }
}
