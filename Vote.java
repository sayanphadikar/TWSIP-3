import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Vote extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JRadioButton candidate1, candidate2, candidate3;
    private JButton voteButton;
    
    private Map<String, Integer> voteCounts;
    
    public Vote() {
        setTitle("Online Voting System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));
        
        titleLabel = new JLabel("Vote for your favorite candidate:");
        candidate1 = new JRadioButton("Candidate 1");
        candidate2 = new JRadioButton("Candidate 2");
        candidate3 = new JRadioButton("Candidate 3");
        voteButton = new JButton("Vote");
        
        ButtonGroup candidateGroup = new ButtonGroup();
        candidateGroup.add(candidate1);
        candidateGroup.add(candidate2);
        candidateGroup.add(candidate3);
        
        voteButton.addActionListener(this);
        
        add(titleLabel);
        add(candidate1);
        add(candidate2);
        add(candidate3);
        add(voteButton);
        
        voteCounts = new HashMap<>();
        voteCounts.put("Candidate 1", 0);
        voteCounts.put("Candidate 2", 0);
        voteCounts.put("Candidate 3", 0);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (candidate1.isSelected()) {
            voteCounts.put("Candidate 1", voteCounts.get("Candidate 1") + 1);
            JOptionPane.showMessageDialog(this, "You voted for Candidate 1!");
        } else if (candidate2.isSelected()) {
            voteCounts.put("Candidate 2", voteCounts.get("Candidate 2") + 1);
            JOptionPane.showMessageDialog(this, "You voted for Candidate 2!");
        } else if (candidate3.isSelected()) {
            voteCounts.put("Candidate 3", voteCounts.get("Candidate 3") + 1);
            JOptionPane.showMessageDialog(this, "You voted for Candidate 3!");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a candidate.");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Vote());
    }
}
