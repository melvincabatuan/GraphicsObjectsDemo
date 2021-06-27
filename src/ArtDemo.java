import acm.graphics.*;
import acm.program.*;
import acm.util.*;



public class ArtDemo extends ConsoleProgram{

    private RandomGenerator rgen = RandomGenerator.getInstance();
    private static GCanvas canvas;
    public static final int NUM_OBJECTS = 60;
    public static final String PROMPT_MESSAGE = "Choose a graphics object:\n"
            + "1: Arc \n"
            + "2: Image \n"
            + "3: Label \n"
            + "4: Line \n"
            + "5: Oval \n"
            + "6: Rectangle \n"
            + "7: Polygon \n"
            + "8: Random \n"
            + "0: Quit (or n < 0) \n";

    /** Intializes graphical canvas */
    public void init() {
        canvas = new GCanvas();
        add(canvas);
    }

    public void run() {
        println("WELCOME TO OBJECTS DEMO!");
        int choice = 0;
        do {
            println(PROMPT_MESSAGE);
            choice = readInt(">> ");
            switch (choice) {
                case 1:
                    canvas.removeAll(); // clear canvas for new art
                    arcArt();
                    break;
                case 2:
                    canvas.removeAll();
                    imageArt();
                    break;
                case 3:
                    canvas.removeAll();
                    labelArt();
                    break;
                case 4:
                    canvas.removeAll();
                    lineArt();
                    break;
                case 5:
                    canvas.removeAll();
                    ovalArt();
                    break;
                case 6:
                    canvas.removeAll();
                    rectArt();
                    break;
                case 7:
                    canvas.removeAll();
                    polygonArt();
                    break;
                case 8:
                    canvas.removeAll();
                    randomArt();
                    break;
                default:
                    println("ERROR: Invalid input! choose 1 to 7 or 0 to quit!");
            } // end of switch
        } while (choice > 0); // end of loop
        println("Exiting.. bye!");
    }

    private void randomArt() {
        System.out.println("Running randomArt()");
        arcArt();
        imageArt();
        labelArt();
        lineArt();
        ovalArt();
        rectArt();
        polygonArt();
    }


    private void polygonArt() {
        System.out.println("Running polygonArt()");
        for (int i = 0; i < 2*NUM_OBJECTS; i++) {
            int side = rgen.nextInt(30, 100);
            int num_sides = rgen.nextInt(3, 10);
            GPolygon hex = new GPolygon();
            hex.addVertex(-side, 0);
            int angle = 360 / num_sides;
            for (int j = 0; j < num_sides; j++) {
                hex.addPolarEdge(side, angle- j * angle);
            }
            addShape(hex);
        }
    }

    /**
     * Constructs a new rectangle with the specified width and height, positioned at the origin.
     *
     *
     * Usage: 	GRect grect = new GRect(width, height);
     * Parameters:
     * width  	The width of the rectangle in pixels
     * height  	The height of the rectangle in pixels
     */
    private void rectArt() {
        System.out.println("Running rectArt()");
        for (int i = 0; i < 2*NUM_OBJECTS; i++) {
            double width = rgen.nextDouble(10, 100);
            double height = rgen.nextDouble(10, 100);
            GRect grect = new GRect(width, height);
            addShape(grect);
        }
    }

    /**
     * Constructs a new oval with the specified width and height, positioned at the origin.
     *
     * Usage: 	GOval goval = new GOval(width, height);
     * Parameters:
     * width  	The width of the oval in pixels
     * height  	The height of the oval in pixels
     */
    private void ovalArt() {
        System.out.println("Running ovalArt()");
        for (int i = 0; i < 2*NUM_OBJECTS; i++) {
            double width = rgen.nextDouble(10, 100);
            double height = rgen.nextDouble(10, 100);
            GOval goval = new GOval(width, height);
            addShape(goval);
        }
    }

    /**
     * Constructs a line segment from its endpoints.
     * The point (x0, y0) defines the start of the line and the point (x1, y1) defines the end.
     *
     *
     * Usage: 	GLine gline = new GLine(x0, y0, x1, y1);
     * Parameters:
     * x0  	The x-coordinate of the start of the line
     * y0  	The y-coordinate of the start of the line
     * x1  	The x-coordinate of the end of the line
     * y1  	The y-coordinate of the end of the line
     */
    private void lineArt() {
        System.out.println("Running lineArt()");
        for (int i = 0; i < 20*NUM_OBJECTS; i++) {
            double x0 = rgen.nextDouble(0, getWidth());
            double y0 = rgen.nextDouble(0, getHeight());
            double x1 = rgen.nextDouble(0, getWidth());
            double y1 = rgen.nextDouble(0, getHeight());
            GLine gline = new GLine(x0, y0, x1, y1);
            addShape(gline);
        }
    }

    /**
     * GLabel(String str)
     * Creates a new GLabel object initialized to contain the specified string.
     *
     *
     * Usage: 	GLabel glabel = new GLabel(str);
     * Parameter:
     * str  	The initial contents of the GLabel
     */
    private void labelArt() {
        System.out.println("Running labelArt()");
        for (int i = 0; i < NUM_OBJECTS; i++) {
            GLabel label = new GLabel("Hello, lbycpei!");
            label.setFont("SansSerif-100");
            addShape(label);
        }
    }

    /**
     Usage: 	GImage gimage = new GImage(name);
     Parameter:
     name  	The name used to search for the contents of this image
     */
    private void imageArt() {
        System.out.println("Running imageArt()");
        for (int i = 0; i < NUM_OBJECTS; i++) {
            GImage gimage = new GImage("assets/icon.png");
            gimage.scale(rgen.nextDouble(0.05,0.2));
            addShape(gimage);
        }
    }

    /**
     Usage: 	GArc garc = new GArc(width, height, start, sweep);
     Parameters:
     width  	The width of the rectangle in which the arc is inscribed
     height  	The height of the rectangle in which the arc is inscribed
     start  	The angle at which the arc begins measured in degrees counterclockwise from the +x axis
     sweep  	The extent of the arc, measured in degrees counterclockwise
     */
    private void arcArt() {
        System.out.println("Running arcArt()");
        for (int i = 0; i < NUM_OBJECTS; i++) {
            int width = 200;
            int height = 200;
            int start = rgen.nextInt(0, 360);
            int sweep = rgen.nextInt(0, 360);
            GArc garc = new GArc(width, height, start, sweep);
            garc.setFilled(true);
            addShape(garc);
        }
    }

    private void addShape(GObject gobj) {
        gobj.setColor(rgen.nextColor());
        if (gobj instanceof GFillable) ((GFillable) gobj).setFilled(true);
        // Add to random location
        double x = rgen.nextDouble(0, getWidth() - gobj.getWidth())
                - gobj.getBounds().getX();
        double y = rgen.nextDouble(0, getHeight() - gobj.getHeight())
                - gobj.getBounds().getY();
        canvas.add(gobj, x, y);
    }

    public static void main(String[] args) {
        new ArtDemo().start(args);
    }
}
