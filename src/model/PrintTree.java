/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonatas
 */
public class PrintTree {

    public static String print(No root) {
        String arvore = "<html>";

        List<List<String>> lines = new ArrayList<>();

        List<No> level = new ArrayList<>();
        List<No> next = new ArrayList<>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();

            nn = 0;

            for (No n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.getValor().toString();
                    if (n.getCor().equals("PRETO")) {
                        aa = "<font color=\"black\"> " + n.getValor() + " </font>,";
                    } else {
                        aa = "<font color=\"red\"> " + n.getValor() + " </font>,";
                    }
                    line.add(aa);
                    if (aa.length() > widest) {
                        widest = aa.length();
                    }

                    next.add(n.getEsquerda());
                    next.add(n.getDireita());

                    if (n.getEsquerda() != null) {
                        nn++;
                    }
                    if (n.getDireita() != null) {
                        nn++;
                    }
                }
            }

            if (widest % 2 == 1) {
                widest++;
            }

            lines.add(line);

            List<No> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    String c = "&nbsp;";
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? "|" : ".";
                        } else {
                            if (j < line.size() && line.get(j) != null) {
                                c = ".";
                            }
                        }
                    }
                    System.out.print(c);
                    arvore += c;

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print("&nbsp;");
                            arvore += "&nbsp;";
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "&nbsp;" : ".");
                            arvore += j % 2 == 0 ? "&nbsp;" : ".";

                        }
                        System.out.print(j % 2 == 0 ? "/" : "\\");
                        arvore += j % 2 == 0 ? "/" : "\\";

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "." : "&nbsp;");
                            arvore += j % 2 == 0 ? "." : "&nbsp;";
                        }
                    }
                }
                System.out.println();
                arvore += "<br>";
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) {
                    f = "";
                }
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print("&nbsp;");
                    arvore += "&nbsp;";
                }
                System.out.print(f);
                arvore += f;

                for (int k = 0; k < gap2; k++) {
                    System.out.print("&nbsp;");
                    arvore += "&nbsp;";
                }
            }
            System.out.println();
            arvore += "<br>";

            perpiece /= 2;
        }
        return arvore + "</html>";
    }
}
