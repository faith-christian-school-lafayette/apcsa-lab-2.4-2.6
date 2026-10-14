# Lab 2.4-2.6 — Nested, Compound, and Equivalent Conditions

Seven short methods in `LogicLab.java`, each one a decision from TicketKiosk,
the movie-ticket program from your Unit 2A notes. The instructions for each
part are in the comment block directly above the method, so read them there —
this page is just the map.

Plan on 30 to 45 minutes.

## What you will practice

- Multiway selection with `if`-`else if`-`else`, where only the first true
  branch runs.
- Nesting one `if` inside another.
- Joining conditions with `&&`, `||` and `!`.
- Rewriting a condition with De Morgan's law.
- Comparing a reference with `null`, and letting short-circuit evaluation
  protect a method call.
- Telling the same object from two objects with the same characters.

## Getting started

1. Open this folder in your editor.
1. Open `src/main/java/LogicLab.java`. That is the only file you change.
1. Work down the file. Each part is marked with a comment that starts with
   `TODO`; replace the placeholder line under it with your own code.

To run your program and see your output:

```sh
mvn -q compile exec:java
```

Your teacher will run a separate set of tests on your work when you turn it in.

## The parts

| Part | Method | What it is about |
| --- | --- | --- |
| 1 | `ticketType(int)` | multiway selection: the first true branch wins |
| 2 | `isOpen(int)` | `&&` for "between" |
| 3 | `needsAdult(int, int)` | an `if` nested inside an `if` |
| 4 | `isClosed(int)` | De Morgan's law, with no `!` |
| 5 | `promoLine(String)` | `== null` asks whether there is an object |
| 6 | `promoDiscount(String, int, boolean)` | a null check before `equals` |
| 7 | `compareCodes(String, String)` | `==` versus `equals` on objects |

## Before you turn it in

- [ ] Every placeholder line under a `TODO` has been replaced with real code.
- [ ] `mvn -q compile exec:java` runs without errors.
- [ ] Part 1 gives `"Child"` for 12, `"Adult"` for 13 and 64, and `"Senior"`
      for 65.
- [ ] Part 4 has no `!` in it, and gives the opposite of Part 2 for every hour.
- [ ] Parts 5 and 6 never call a method on `promo` before checking that it is
      not `null`.
- [ ] Part 7 tests `==` before `equals`.
- [ ] You did not rename any method, change any parameter list, or change any
      return type. The grader compiles against those exact signatures, so a
      rename means a zero even if your logic is perfect.

`main` is not graded, so you may change it however you like.

## Optional extension, not graded

The expression `isChild || isSenior && wants3D` is not the same as
`(isChild || isSenior) && wants3D`. Make a truth table with a row for every
combination of the three values, find the rows where the two expressions
disagree, and explain why using the precedence of `!`, `&&` and `||`.
