/**
 * AP CSA Lab 2.4-2.6 - Nested, Compound, and Equivalent Conditions
 *
 * Fill in the body of each method in LogicLab below. Do not rename anything,
 * do not change the parameter lists, and do not change the return types. The
 * grader compiles against these exact signatures.
 *
 * Every part is one decision from TicketKiosk, the movie-ticket program from
 * your notes (Appendix A). The rules are the same ones:
 *
 *     shows start from hour 10 through hour 22
 *     a child is 12 or under, a senior is 65 or over, anyone else is an adult
 *     a matinee starts before hour 17
 *     code FILMCLUB saves $1.50; code EARLYBIRD saves $2.00 on a 2D matinee
 *     only
 *     a guest under 17 at a show starting at hour 21 or later needs an adult
 *
 * Money is kept in whole cents, so 150 means $1.50. Each part tells you which
 * lines of TicketKiosk it matches, so you can look back at them.
 *
 * Run the program with:  mvn -q compile exec:java
 * Or from your IDE, just run main.
 */
public class LogicLab
{
    // ---------------------------------------------------------------
    // PART 1: multiway selection runs at most one branch
    //
    // Return the ticket type for a guest of this age: "Child" for 12 or
    // under, "Senior" for 65 or over, and "Adult" for everyone else.
    //
    // TicketKiosk lines 63-76:
    //
    //     if (isChild)
    //     {
    //         ticketType = "Child";
    //         ...
    //     }
    //     else if (isSenior)
    //     {
    //         ticketType = "Senior";
    //         ...
    //     }
    //     else
    //     {
    //         ticketType = "Adult";
    //     }
    //
    // A multiway selection (if-else-if) checks its expressions from the top
    // down. Only the segment of code for the FIRST expression that is true
    // runs, and the rest are never even evaluated. If none is true, the
    // trailing else runs.
    //
    // Example: ticketType(12) is "Child"
    // Example: ticketType(13) is "Adult"
    // Example: ticketType(65) is "Senior"
    //
    // Careful: the order of the branches matters. If the first test is
    // age < 65 for "Adult", an 8-year-old gets "Adult" -- 8 < 65 is the first
    // true expression, so the Child branch is never reached.
    // ---------------------------------------------------------------
    public static String ticketType(int age)
    {
        // TODO Part 1: use if, else if, else to return the ticket type
        return "";
    }

    // ---------------------------------------------------------------
    // PART 2: && is true only when both sides are true
    //
    // Return true if a show can start at this hour: hour 10 through hour 22,
    // both ends included. Return false otherwise.
    //
    // TicketKiosk line 41:   boolean isOpen = hour >= 10 && hour <= 22;
    //
    // The logical operators are ! (not), && (and), and || (or).
    //
    //     a && b    true if both a and b are true, and false otherwise
    //     a || b    true if a is true, b is true, or both
    //     !a        true if a is false, and false otherwise
    //
    // Java has no way to write 10 <= hour <= 22 in one comparison. You ask
    // two questions and join them.
    //
    // Example: isOpen(10) is true
    // Example: isOpen(22) is true
    // Example: isOpen(9)  is false
    // Example: isOpen(23) is false
    //
    // Careful: hour >= 10 || hour <= 22 is true for EVERY hour, because every
    // number is at least 10 or at most 22. "Between" needs &&.
    // ---------------------------------------------------------------
    public static boolean isOpen(int hour)
    {
        // TODO Part 2: join two comparisons with &&
        return false;
    }

    // ---------------------------------------------------------------
    // PART 3: a nested if is checked only when the outer one is true
    //
    // Return true if a guest of this age needs an adult with them at a show
    // starting at this hour, and false otherwise. A guest needs an adult when
    // the show starts at hour 21 or later AND the guest is under 17.
    //
    // TicketKiosk lines 136-142:
    //
    //     if (hour >= 21)
    //     {
    //         if (age < 17)
    //         {
    //             System.out.println("Guests under 17 need an adult with them.");
    //         }
    //     }
    //
    // Write it the same way, with one if nested inside another, and return
    // true from inside the inner if. The Boolean expression of the inner if
    // is evaluated only if the outer one is true, so for an early show the
    // age is never even checked. Every other way through the method must
    // return false.
    //
    // Example: needsAdult(16, 22) is true
    // Example: needsAdult(10, 19) is false  (the age is never checked)
    // Example: needsAdult(40, 21) is false  (the age is checked, and fails)
    //
    // Careful: a guest who is exactly 17 does NOT need an adult -- 17 < 17 is
    // false. And joining the two tests with || would send every late-show
    // adult home with a warning.
    // ---------------------------------------------------------------
    public static boolean needsAdult(int age, int hour)
    {
        // TODO Part 3: an if inside an if; return true only from the inner one
        return false;
    }

    // ---------------------------------------------------------------
    // PART 4: De Morgan's law
    //
    // Return true if NO show can start at this hour -- the exact opposite of
    // Part 2 -- and false otherwise.
    //
    // TicketKiosk line 44 asks this as !isOpen, which is
    //
    //     !(hour >= 10 && hour <= 22)
    //
    // Write it WITHOUT the ! operator. Two steps:
    //
    //     1. De Morgan's law: !(a && b) is equivalent to !a || !b, and
    //        !(a || b) is equivalent to !a && !b. The && becomes ||.
    //     2. Flip each comparison: !(x >= 10) is x < 10, and !(x <= 22) is
    //        x > 22.
    //
    // Two Boolean expressions are equivalent if they evaluate to the same
    // value in all cases, so your answer must agree with !isOpen(hour) for
    // every hour.
    //
    // Example: isClosed(9)  is true
    // Example: isClosed(10) is false
    // Example: isClosed(22) is false
    // Example: isClosed(23) is true
    //
    // Careful, two traps here. Flipping the comparisons but keeping && gives
    // hour < 10 && hour > 22, which no hour can satisfy. And watch the
    // boundary: !(x >= 10) is x < 10, not x <= 10.
    // ---------------------------------------------------------------
    public static boolean isClosed(int hour)
    {
        // TODO Part 4: apply De Morgan's law -- no ! allowed
        return false;
    }

    // ---------------------------------------------------------------
    // PART 5: compare a reference with null
    //
    // promo refers to the promo code the guest is using, or it is null when
    // there is no code. Return the receipt line for it:
    //
    //     "Promo: none"          when promo is null
    //     "Promo: " + promo      when promo refers to a String
    //
    // TicketKiosk lines 126-133:
    //
    //     if (promo == null)
    //     {
    //         System.out.println("Promo: none");
    //     }
    //     else
    //     {
    //         System.out.println("Promo: " + promo);
    //     }
    //
    // An object reference can be compared with null, using == or !=, to
    // find out whether it refers to an object at all. That is the one
    // question you may always ask a reference, whatever it holds.
    //
    // Example: promoLine(null)       is "Promo: none"
    // Example: promoLine("FILMCLUB") is "Promo: FILMCLUB"
    // Example: promoLine("")         is "Promo: "
    //
    // Careful: null is not the empty String "". The empty String is a real
    // object with no characters in it, so it gets "Promo: " with nothing
    // after it. And promo.equals(null) is no good: calling a method on null
    // throws a NullPointerException.
    // ---------------------------------------------------------------
    public static String promoLine(String promo)
    {
        // TODO Part 5: test promo == null, then return the right line
        return "";
    }

    // ---------------------------------------------------------------
    // PART 6: short-circuit evaluation guards against null
    //
    // Return how many cents a promo code takes off the ticket:
    //
    //     150    when promo is "FILMCLUB"
    //     200    when promo is "EARLYBIRD" AND the show is a 2D matinee
    //            (before hour 17, and not 3D)
    //     0      for an EARLYBIRD code on any other show
    //     0      for any other code
    //     0      when promo is null (no code was entered)
    //
    // TicketKiosk lines 91-111 (the println lines are left out here):
    //
    //     if (promo != null && promo.equals("FILMCLUB"))
    //     {
    //         cents -= 150;
    //     }
    //     else if (promo != null && promo.equals("EARLYBIRD"))
    //     {
    //         if (isMatinee && !wants3D)
    //         {
    //             cents -= 200;
    //         }
    //         ...
    //     }
    //
    // Short-circuit evaluation: a && b stops as soon as a is false, because
    // the result must be false. So in promo != null && promo.equals(...),
    // equals is never called when promo is null -- the null check guards it.
    //
    // Example: promoDiscount("FILMCLUB", 21, true)   is 150
    // Example: promoDiscount("EARLYBIRD", 11, false) is 200
    // Example: promoDiscount("EARLYBIRD", 11, true)  is 0    (3D)
    // Example: promoDiscount("EARLYBIRD", 19, false) is 0    (evening)
    // Example: promoDiscount(null, 19, false)        is 0
    //
    // Careful: order matters inside the &&. promo.equals("FILMCLUB") &&
    // promo != null calls equals first, so a null promo throws a
    // NullPointerException before the check ever runs. And compare codes
    // with equals, not ==.
    // ---------------------------------------------------------------
    public static int promoDiscount(String promo, int hour, boolean wants3D)
    {
        // TODO Part 6: check promo != null FIRST in each condition
        return 0;
    }

    // ---------------------------------------------------------------
    // PART 7: same object, or just the same characters?
    //
    // Two promo codes are handed to you; neither one is null. Return:
    //
    //     "same object"        when first and second refer to the very
    //                          same String object
    //     "same characters"    when they are two different objects that
    //                          hold the same characters
    //     "different"          otherwise
    //
    // Two different variables can hold references to the same object, and
    // object references can be compared using == and !=. So first == second
    // asks "same object?". Classes often define their own equals method to
    // say when two objects are equivalent; String's equals compares the
    // characters. So first.equals(second) asks "same characters?".
    //
    // In TicketKiosk, line 88 (promo = entered;) makes promo and entered
    // two names for ONE object, so promo == entered is true.
    //
    // Example: two names for one object holding "FILMCLUB" give
    //          "same object"
    // Example: two separate objects both holding "FILMCLUB" give
    //          "same characters"
    // Example: "EARLYBIRD" and "earlybird" give "different"
    //
    // Careful: the same object always has the same characters too, so if you
    // test equals FIRST, every "same object" case comes out
    // "same characters". Ask the more specific question first.
    // ---------------------------------------------------------------
    public static String compareCodes(String first, String second)
    {
        // TODO Part 7: test == first, then equals, then fall through
        return "";
    }

    // ---------------------------------------------------------------
    // Run this to see your own work. The grader does not test main, so you
    // may change it freely while you experiment.
    // ---------------------------------------------------------------
    public static void main(String[] args)
    {
        System.out.println("ticketType(65)                    = " + ticketType(65));
        System.out.println("isOpen(22)                        = " + isOpen(22));
        System.out.println("needsAdult(16, 22)                = " + needsAdult(16, 22));
        System.out.println("isClosed(9)                       = " + isClosed(9));
        System.out.println("promoLine(null)                   = " + promoLine(null));
        System.out.println("promoDiscount(\"EARLYBIRD\", 11, false) = "
            + promoDiscount("EARLYBIRD", 11, false));

        // new String forces a SECOND object holding "FILMCLUB". Writing the
        // literal "FILMCLUB" twice would hand back one shared object.
        String entered = new String("FILMCLUB");
        String promo = entered;
        String typedAgain = new String("FILMCLUB");
        System.out.println("compareCodes(promo, entered)      = " + compareCodes(promo, entered));
        System.out.println("compareCodes(promo, typedAgain)   = " + compareCodes(promo, typedAgain));
    }
}
