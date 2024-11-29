package br.uva.diagnostico;

import com.sun.xml.internal.ws.util.StringUtils;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagnosticInterface extends JFrame {

    private final JTextField inputField;
    private final JTextArea resultArea;
    private final JButton searchButton;

    //Inicialização da interface
    public DiagnosticInterface() {
        setTitle("Sistema de Diagnóstico");
        setSize(1400, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Desenhando a logo com matemática
        final JPanel logoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                final Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                final Color primaryColor = new Color(70, 130, 180), secondaryColor = new Color(51, 65, 85);

                // Desenha o círculo principal (representando a cabeça de um estetoscópio)
                g2d.setColor(primaryColor);
                g2d.fillOval(20, 20, 80, 80);

                // Desenha o tubo do estetoscópio
                g2d.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2d.drawArc(45, 10, 50, 50, 0, 180);

                // Desenha o "+" dentro do círculo
                g2d.setColor(Color.WHITE);
                g2d.setStroke(new BasicStroke(8));
                g2d.drawLine(40, 60, 80, 60);
                g2d.drawLine(60, 40, 60, 80);

                // Desenha o texto com a fonte desejada
                g2d.setColor(secondaryColor);
                g2d.setFont(new Font("Arial", Font.BOLD, 36));
                g2d.drawString("DiagnósticoPRO", 120, 70);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(500, 120);
            }
        };
        logoPanel.setOpaque(false);

        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(25, 25));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 60, 60, 60));
        mainPanel.setBackground(new Color(248, 250, 252)); // Lighter background

        final JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setOpaque(false);

        logoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(logoPanel);
        titlePanel.add(Box.createRigidArea(new Dimension(0, 40)));

        final JTextArea descriptionArea = getDescriptionArea();
        titlePanel.add(descriptionArea);

        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 22));
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setBackground(Color.WHITE);
        resultArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        final JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 0, 25, 0),
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1)
        ));

        final JPanel inputPanel = new JPanel(new BorderLayout(20, 15));
        inputPanel.setOpaque(false);

        final JLabel inputLabel = new JLabel("Sintomas (separados por vírgula):");
        inputLabel.setFont(new Font("Arial", Font.BOLD, 22));
        inputLabel.setForeground(new Color(51, 65, 85));
        inputPanel.add(inputLabel, BorderLayout.NORTH);

        final JPanel searchPanel = new JPanel(new BorderLayout(20, 0));
        searchPanel.setOpaque(false);

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(300, 55));
        inputField.setFont(new Font("Arial", Font.PLAIN, 22));
        inputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));

        searchButton = new JButton("Pesquisar");
        searchButton.setPreferredSize(new Dimension(180, 55));
        searchButton.setBackground(new Color(70, 130, 180));
        searchButton.setForeground(Color.BLACK);
        searchButton.setFocusPainted(false);
        searchButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        searchButton.setFont(new Font("Arial", Font.BOLD, 22));
        searchButton.setOpaque(true);
        searchButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                searchButton.setBackground(new Color(60, 116, 162));
            }

            public void mouseExited(MouseEvent e) {
                searchButton.setBackground(new Color(70, 130, 180));
            }
        });
        searchButton.addPropertyChangeListener("background", evt -> {
            searchButton.setOpaque(true);
        });

        searchPanel.add(inputField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);
        inputPanel.add(searchPanel, BorderLayout.CENTER);
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        add(mainPanel);

        searchButton.addActionListener(e -> performSearch());
        inputField.addActionListener(e -> performSearch());

        loadPrologFile();
    }

    //Gera a área de descrição do projeto
    private static JTextArea getDescriptionArea() {
        final JTextArea descriptionArea = new JTextArea(
                "Este sistema utiliza lógica Prolog para auxiliar no diagnóstico médico preliminar " +
                "com base nos sintomas informados. Insira os sintomas separados por vírgula para " +
                "receber possíveis diagnósticos. Vale lembrar que nenhum diagnóstico obtido por meio " +
                "do sistema não substitui a opinião profissional de um médico. Se realmente estiver sentindo " +
                "que tem algo de errado, procure um especialista."
        );
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 22));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setBackground(null);
        descriptionArea.setForeground(new Color(51, 65, 85));
        descriptionArea.setBorder(BorderFactory.createEmptyBorder(25, 70, 45, 70));
        descriptionArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        return descriptionArea;
    }

    //Inicialização do Prolog (consult)
    private void loadPrologFile() {
        try {
            final URL resource = DiagnosticInterface.class.getClassLoader().getResource("base.pl");
            if(resource == null) throw new Exception("Resource was null");
            final Query consult = new Query("consult", new Term[]{new Atom(resource.getPath().replaceFirst("/", "").replace("/", "\\"))});
            if(consult.hasSolution())
                resultArea.setText("Sistema inicializado e pronto para consultas.\n" +
                                   "Por favor, insira os sintomas separados por vírgula.");
            else throw new Exception("Consult returned no solutions");
        } catch(Exception exception) {
            resultArea.setText("Erro ao consultar a base de conhecimento: " + exception.getMessage());
        }
    }

    private String normalizeText(String str) {
        if(str == null)
            return null;
        String normalized = Normalizer.normalize(str, Normalizer.Form.NFD);
        String noAccent = normalized.replaceAll("\\p{M}", "");
        noAccent = noAccent.replace("ç", "c").replace("Ç", "C");
        return noAccent;
    }

    //Metodo que realiza query no Prolog e retorna o resultado
    private void performSearch() {
        String input = inputField.getText().trim();
        if(input.isEmpty()) {
            resultArea.setText("Por favor, insira pelo menos um sintoma para pesquisar.");
            return;
        }
        try {
            final String[] symptoms = input.replace(" e ", ", ").replace(", ", ",").split(",");
            final StringBuilder result = new StringBuilder();
            final Term[] symptomTerms = new Term[symptoms.length];
            for(int i = 0; i < symptoms.length; i++) {
                final String processedSymptom = normalizeText(symptoms[i].trim().toLowerCase().replaceFirst(" ", "").replace(' ', '_'));
                symptomTerms[i] = new Atom(processedSymptom);
            }
            result.append(String.format("Analisando os seguintes sintomas (%s): %s\n", symptoms.length, Arrays.toString(symptoms).replace("[", "").replace("]", "")))
                    .append("\nResultados:\n\n");
            final Term symptomList = Term.termArrayToList(symptomTerms);
            final Query causeQuery = new Query("diagnostico_preciso", new Term[]{symptomList, new Variable("X")});
            final List<String> causes = new ArrayList<>();
            while(causeQuery.hasMoreSolutions()) {
                final String causeRaw = causeQuery.nextSolution().get("X").toString().replace("_", " ");
                final StringBuilder cause = new StringBuilder();
                for(String s : causeRaw.split(" "))
                    cause.append(StringUtils.capitalize(s));
                causes.add(cause.toString());
            }
            if(causes.isEmpty()) {
                result.append("Nenhum diagnóstico encontrado para os sintomas informados.");
            } else {
                result.append("Possíveis causas (").append(causes.size()).append("): ").append(causes.toString().replace("[", "").replace("]", "")).append("\n");
                if(causes.size() > 1)
                    result.append("\nA descrição dos seus sintomas pode ter sido vaga, o que resulta em múltiplas possíveis doenças. Tente ser mais específico para conseguir um melhor resultado.");
                else {
                    result.append("\nParece que você conseguiu um diagnóstico preciso. Seus sintomas coincidem totalmente com a doença indicada.");
                    final Query specialistQuery = new Query("especialista", new Term[]{new Atom(causes.get(0).toLowerCase().trim().replace(" ", "_")), new Variable("X")});
                    if(specialistQuery.hasSolution()) {
                        final String specialistRaw = specialistQuery.nextSolution().get("X").toString().replace("_", " ");
                        final StringBuilder specialist = new StringBuilder();
                        for(String s : specialistRaw.split(" "))
                            specialist.append(StringUtils.capitalize(s));
                        result.append(String.format("\nVocê precisa consultar um %s com brevidade.", specialist));
                    } else
                        result.append("\nNão foi possível determinar o especialista que você precisa visitar. Procure um Clínico Geral.");
                }
            }
            resultArea.setText(result.toString());
            inputField.selectAll();
        } catch(Exception e) {
            resultArea.setText("Erro ao processar a consulta: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //Inicializar o APP
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new DiagnosticInterface().setVisible(true));
    }
}