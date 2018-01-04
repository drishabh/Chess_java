/**
 * @author Rishabh Dalal
 */


public class ConsoleColor {
	// For printing different pieces of different players in color (Red/Blue)
	
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   
    public static final String RED = "\033[0;31m";     
    public static final String GREEN = "\033[0;32m";   
    public static final String YELLOW = "\033[0;33m";  
    public static final String BLUE = "\033[0;34m";    

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  
    public static final String RED_BOLD = "\033[1;31m";    
    public static final String GREEN_BOLD = "\033[1;32m";  
    public static final String YELLOW_BOLD = "\033[1;33m"; 
    public static final String BLUE_BOLD = "\033[1;34m";    

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  
    public static final String RED_BACKGROUND = "\033[41m";    
    public static final String GREEN_BACKGROUND = "\033[42m";  
    public static final String YELLOW_BACKGROUND = "\033[43m"; 
    public static final String BLUE_BACKGROUND = "\033[44m";   

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  
    public static final String RED_BRIGHT = "\033[0;91m";    
    public static final String GREEN_BRIGHT = "\033[0;92m";  
    public static final String YELLOW_BRIGHT = "\033[0;93m"; 
    public static final String BLUE_BRIGHT = "\033[0;94m";   

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; 
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; 
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
}
