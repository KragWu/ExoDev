package domain;

public class SearchGameValid {

    public static int isItValid(String line, int mode) {
        int result = 0;
        String[] splitLines = line.split(":");
        int idGame = Integer.parseInt(splitLines[0].replace("Game ", ""));
        int cptNbRed = 0;
        int maxRed = 0;
        int cptNbGreen = 0;
        int maxGreen = 0;
        int cptNbBlue = 0;
        int maxBlue = 0;
        boolean isValid = true;
        String[] setGame = splitLines[1].split(";");
        for (String set : setGame) {
            System.out.println(set);
            String[] maybeRed = set.split(" red");
            if (maybeRed.length >= 1) {
                int nbRed = 0;
                try {
                    nbRed = Integer.parseInt(
                            String.valueOf(maybeRed[0].charAt(maybeRed[0].length() - 2))
                                    .concat(String.valueOf(maybeRed[0].charAt(maybeRed[0].length() - 1))).trim());
                    if (maxRed < nbRed) maxRed = nbRed;
                } catch (NumberFormatException nfe) {
                    System.out.println();
                }
                if (nbRed > 12) isValid = false;
                cptNbRed = cptNbRed + nbRed;
            }
            String[] maybeBlue = set.split(" blue");
            if (maybeBlue.length >= 1) {
                int nbBlue = 0;
                try {
                    nbBlue = Integer.parseInt(
                            String.valueOf(maybeBlue[0].charAt(maybeBlue[0].length() - 2))
                                    .concat(String.valueOf(maybeBlue[0].charAt(maybeBlue[0].length() - 1))).trim());
                    if (maxBlue < nbBlue) maxBlue = nbBlue;
                } catch (NumberFormatException nfe) {
                    System.out.println();
                }
                if (nbBlue > 14) isValid = false;
                cptNbBlue = cptNbBlue + nbBlue;
            }
            String[] maybeGreen = set.split(" green");
            if (maybeGreen.length >= 1) {
                int nbGreen = 0;
                try {
                    nbGreen = Integer.parseInt(
                            String.valueOf(maybeGreen[0].charAt(maybeGreen[0].length() - 2))
                                    .concat(String.valueOf(maybeGreen[0].charAt(maybeGreen[0].length() - 1))).trim());
                    if (maxGreen < nbGreen) maxGreen = nbGreen;
                } catch (NumberFormatException nfe) {
                    System.out.println();
                }
                if (nbGreen > 13) isValid = false;
                cptNbGreen = cptNbGreen + nbGreen;
            }
            System.out.printf("Game %s : number Red = %s, number Blue = %s, number Green = %s%n", idGame, cptNbRed, cptNbBlue, cptNbGreen);
        }
        System.out.printf("Game %s : final number Red = %s, final number Blue = %s, final number Green = %s%n", idGame, cptNbRed, cptNbBlue, cptNbGreen);

        result = mode == 2 ? maxRed * maxBlue * maxGreen : idGame;
        System.out.printf("Game %s : max Red = %s, max Blue = %s, max Green = %s%n", idGame, maxRed, maxBlue, maxGreen);
        System.out.printf("Game %s : mode : %d - result = %s%n", idGame, mode, result);
        return isValid || mode == 2 ? result : 0;
    }
}
