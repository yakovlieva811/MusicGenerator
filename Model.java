import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Set;

public class Model {


public int checkFillFormReg(JTextField login,JTextField  firstName,JTextField  lastName, JTextField email,JTextField pass, JTextField passConfirm){
    if(pass.getText().equals(passConfirm.getText())){
       if(!login.getText().isEmpty() & !firstName.getText().isEmpty() & !lastName.getText().isEmpty() & !email.getText().isEmpty() &!pass.getText().isEmpty()){
         return 1;
        }else{
         return 2;
        }
    }else{
    return 0;
    }


}
    public DefaultTableModel combineSongs (DefaultTableModel fromSimPL, DefaultTableModel sameGenre, Set<Object> groupSelected){
        DefaultTableModel songsModel = new DefaultTableModel();
        Object[] columnsHeader = new String[]{"Song", "Group", "Genre"};
        songsModel.setColumnIdentifiers(columnsHeader);
        Object[] groupsSelected = groupSelected.toArray();
         for (int j=0;j<groupsSelected.length;j++) {

             for (int i = 0; i<fromSimPL.getRowCount();i++ ){
                 if(!fromSimPL.getValueAt(i,1).toString().equals(groupsSelected[j].toString())){
                String song = fromSimPL.getValueAt(i,0).toString();
                String group = fromSimPL.getValueAt(i,1).toString();
                String genre = fromSimPL.getValueAt(i,2).toString();
                String data [] = {song,group,genre};
                songsModel.addRow(data);
        }}
            for (int i = 0; i<sameGenre.getRowCount();i++ ){
                if(!sameGenre.getValueAt(i,1).toString().equals(groupsSelected[j].toString())){
                String song = sameGenre.getValueAt(i,0).toString();
                String group = sameGenre.getValueAt(i,1).toString();
                String genre = sameGenre.getValueAt(i,2).toString();
                String data [] = {song,group,genre};
                songsModel.addRow(data);
        }}}
        return songsModel;
    }
}
