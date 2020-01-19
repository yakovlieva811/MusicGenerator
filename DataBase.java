import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;

public class DataBase {
    DefaultTableModel modelAllSongs;
    DefaultTableModel randSongs;
    DefaultTableModel selectionSongs;
    DefaultTableModel moreSongs;
    Set<Object> groupSet = new LinkedHashSet<>();
    Object[] columnsHeader = new String[]{"Song", "Group", "Genre"};



    public DefaultTableModel getModelAllSongs() {
        return modelAllSongs;
    }




    public void setModelAllSongs(DefaultTableModel modelAllSongs) {
        this.modelAllSongs = modelAllSongs;
    }




    public void checkuser(String login, String pass) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            PreparedStatement st = connection.prepareStatement("SELECT * FROM musicgenerator.users where login = ? ");
            st.setString(1, login);
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {
                if (r1.getString("password").equals(pass)) {
                    JOptionPane.showMessageDialog(null, "Вы вошли.");
                } else {
                    JOptionPane.showMessageDialog(null, "Неверный пароль.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Пользователь не найден.");
            }
        } catch (SQLException e1) {
            System.out.println(e1);
        }
    }




     public void addPLname(String playlistName) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            PreparedStatement Pstatement = connection.prepareStatement("insert into musicgenerator.playlists values(?,null)");
            Pstatement.setString(1, playlistName);
            Pstatement.executeUpdate();
        } catch (SQLException e1) {
            System.out.println(e1);
        }
    }




    public int getPLid(String namePl) {
        int id = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            PreparedStatement st = connection.prepareStatement("SELECT id FROM  musicgenerator.playlists where playlist_name = ? ");
            st.setString(1, namePl);
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {
                id = r1.getInt("id");
                System.out.println(" r1.getInt(id);" + r1.getInt("id"));
            } else {
                JOptionPane.showMessageDialog(null, "Пользователь не найден.");
            }
        } catch (SQLException e1) {
            System.out.println(e1);
        }

        return id;
    }




    public int getUserId(String login) {
        int id = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            PreparedStatement st = connection.prepareStatement("SELECT id FROM  musicgenerator.users where login = ? ");
            st.setString(1, login);
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {
                id = r1.getInt("id");
                System.out.println(" r1.getUserId(id)= " + r1.getInt("id"));
            } else {
                JOptionPane.showMessageDialog(null, "Пользователь не найден.");
            }
        } catch (SQLException e1) {
            System.out.println(e1);
        }
        return id;
    }




    public int getSongId(String song) {
        int id = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            PreparedStatement st = connection.prepareStatement("SELECT id FROM  musicgenerator.music where song = ? ");
            st.setString(1, song);
            ResultSet r1 = st.executeQuery();
            if (r1.next()) {
                id = r1.getInt("id");
                System.out.println(" getSongId(id)= " + r1.getInt("id"));
            } else {
                JOptionPane.showMessageDialog(null, "Пользователь не найден.");
            }
        } catch (SQLException e1) {
            System.out.println(e1);
        }
        return id;
    }




   public void addPlaylistHasMusic(int playlistId, int songId) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            PreparedStatement Pstatement = connection.prepareStatement("insert into musicgenerator.playlists_has_music (playlists_id, music_id) values(?,?)");
            Pstatement.setInt(1, playlistId);
            Pstatement.setInt(2, songId);
            Pstatement.executeUpdate();
        } catch (SQLException e1) {
            System.out.println(e1);
        }
    }




    public void addUserHasPL(int idUser, int idPL) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            PreparedStatement Pstatement = connection.prepareStatement("insert into musicgenerator.users_has_playlists ( users_id ,playlists_id ) values(?,?)");
            Pstatement.setInt(1, idUser);
            Pstatement.setInt(2, idPL);
            Pstatement.executeUpdate();
        } catch (SQLException e1) {
            System.out.println(e1);
        }
    }




   public void addUser(String login, String firstName, String lastName, String email, String pass) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            PreparedStatement Pstatement = connection.prepareStatement("insert into musicgenerator.users values(?,?,?,?,?,null)");
            Pstatement.setString(1, login);
            Pstatement.setString(2, pass);
            Pstatement.setString(3, firstName);
            Pstatement.setString(4, lastName);
            Pstatement.setString(5, email);
            Pstatement.executeUpdate();
        } catch (SQLException e1) {
            System.out.println(e1);
        }
    }




   public void getAllSongs() {
        ResultSet rs = null;
        modelAllSongs = new DefaultTableModel();
        modelAllSongs.setColumnIdentifiers(columnsHeader);
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            String query = "SELECT * FROM musicgenerator.music";
            Statement st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String song = rs.getString("song");
                String group = rs.getString("group");
                String genre = rs.getString("genre");
                String link = rs.getString("link");
                String[] data = {song, group, genre, link};
                System.out.println(song + " " + genre + " " + group + " " + link);
                modelAllSongs.addRow(data);
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }




    public DefaultTableModel get5Rand() {
        int rowAmmount = modelAllSongs.getRowCount();
        Random random = new Random();
        randSongs = new DefaultTableModel();
        randSongs.setColumnIdentifiers(columnsHeader);
        for (int i = 0; i < 5; i++) {
            int num = random.nextInt(rowAmmount);
            String song = modelAllSongs.getValueAt(num, 0).toString();
            String group = modelAllSongs.getValueAt(num, 1).toString();
            String genre = modelAllSongs.getValueAt(num, 2).toString();
            String[] data = {song, group, genre};
            System.out.println(song + " " + group + " " + genre);
            randSongs.addRow(data);
        }
        System.out.println("  randSongs.getValueAt(1,1)  " + modelAllSongs.getValueAt(1, 1).toString());
        return randSongs;
    }




    public Set<Object> getGroupsSet() {
        for (int i = 0; i < modelAllSongs.getRowCount(); i++) {
            groupSet.add(modelAllSongs.getValueAt(i, 1));
        }
        return groupSet;
    }




    public  int[] getIdGroup(Set<Object> groupSelected) {
        Object[] groups = groupSelected.toArray();
        int[] id = new int[groups.length];
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            System.out.println("id треков выбраных групп: " );
            for(int i=0;i<groups.length;i++){
                System.out.println("группа " + groups[i].toString());
                PreparedStatement st = connection.prepareStatement("SELECT id FROM  musicgenerator.music where music.group = ? ");
                st.setString(1, groups[i].toString());
                ResultSet r1=st.executeQuery();
                while (r1.next()) {
                    id[i] = r1.getInt("id");
                    System.out.println(" id  трека = " +  id[i]);
                }
            }
        }catch(SQLException e1) {
            System.out.println(e1);
        }
return id;
    }




    public  Set<Integer>  getIdPlaylist(int[] idGroup) {
        Set<Integer> playId =  new LinkedHashSet<>();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            for(int i=0;i<idGroup.length;i++){
                PreparedStatement st = connection.prepareStatement("SELECT playlists_id FROM musicgenerator.playlists_has_music where music_id = ? ");
                st.setInt(1, idGroup[i]);
                ResultSet r1=st.executeQuery();
                while (r1.next()) {
                    playId.add(r1.getInt("playlists_id"));
                    System.out.println(" id  плейлиста с треками = " +  r1.getInt("playlists_id"));
                }
            }
        }catch(SQLException e1) {
            System.out.println(e1);
        }
        return playId;
    }




    public   HashMap<Integer, Integer> getIdSong(Set<Integer> playId) {
        Object [] playIdArray = playId.toArray();
        HashMap<Integer, Integer> songsMap = new HashMap<Integer, Integer>();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            for(int i=0;i<playIdArray.length;i++){
                PreparedStatement st = connection.prepareStatement("SELECT music_id FROM musicgenerator.playlists_has_music where playlists_id = ? ");
                st.setInt(1, Integer.valueOf(playIdArray[i].toString()));
                ResultSet r1=st.executeQuery();
                while (r1.next()) {
                    Integer songId  = r1.getInt("music_id");
                    if(songsMap.containsKey(songId)) {
                        songsMap.put(songId, songsMap.get(songId) + 1);
                    }
                    else{
                        songsMap.put(songId, 1);
                    }
                }
            }
            System.out.println(" map - счетчик треков ");
            for(Map.Entry<Integer, Integer> entry : songsMap.entrySet()) {
                System.out.println("song id: " +entry.getKey() + " кол-во: "+entry.getValue() + "\n");
                if(entry.getValue()>1){
                    System.out.println(" повторяющиеся song id: " +entry.getKey() + " кол-во: "+entry.getValue() + "\n");
                }
            }
        }catch(SQLException e1) {
            System.out.println(e1);
        }

        return songsMap;
    }




   public DefaultTableModel getMusicAfterSelection( HashMap<Integer, Integer>  songMap){  // вывод треков отобранных по плейлистам
        selectionSongs = new DefaultTableModel();
        selectionSongs.setColumnIdentifiers(columnsHeader);
        ArrayList<Integer> idSons = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : songMap.entrySet()) {
            if(entry.getValue()>1) {
                idSons.add(entry.getKey()); // треки повторяющиеся в отобраных плейлисах
            }
        }
        ResultSet rs = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            PreparedStatement st = connection.prepareStatement("SELECT * FROM musicgenerator.music where music.id = ?");
            for(int i = 0; i<idSons.size(); i++) {
            st.setInt(1,idSons.get(i));
            rs = st.executeQuery();
            while (rs.next()) {
                String song = rs.getString("song");
                String group = rs.getString("group");
                String genre = rs.getString("genre");
                String link = rs.getString("link");
                String[] data = {song, group, genre};
                System.out.println( " отбранные треки 666 : " +song + " " + genre + " " + group );
                selectionSongs.addRow(data);
            }
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
return selectionSongs;
    }

    public Set<Object> getGenreGroup(Set<Object> groupSelected) {
        Object[] groups = groupSelected.toArray();
        Set<Object> groupGenre = new LinkedHashSet<>();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            System.out.println("id треков выбраных групп: " );
            for(int i=0;i<groups.length;i++){
                System.out.println("группа " + groups[i].toString());
                PreparedStatement st = connection.prepareStatement("SELECT genre FROM  musicgenerator.music where music.group = ? ");
                st.setString(1, groups[i].toString());
                ResultSet r1=st.executeQuery();
                while (r1.next()) {
                    groupGenre.add(r1.getString("genre"));
                }
            }
        }catch(SQLException e1) {
            System.out.println(e1);
        }
        return groupGenre;
    }

    public DefaultTableModel getAnotherMusic(Set<Object> groupGenre){
        Object[] groups = groupGenre.toArray();
        moreSongs = new DefaultTableModel();
        moreSongs.setColumnIdentifiers(columnsHeader);
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicgenerator?useSSL=false", "root", "0109");
            System.out.println("id треков выбраных групп: " );
            for(int i=0;i<groups.length;i++){
                System.out.println("группа " + groups[i].toString());
                PreparedStatement st = connection.prepareStatement("SELECT * FROM  musicgenerator.music where music.genre = ? ");
                st.setString(1, groups[i].toString());
                ResultSet r1=st.executeQuery();
                while (r1.next()) {
                    String song = r1.getString("song");
                    String group = r1.getString("group");
                    String genre = r1.getString("genre");
                    String link = r1.getString("link");
                    String[] data = {song, group, genre};
                    System.out.println( " отбранные треки по жанру: " +song + " " + genre + " " + group );
                    moreSongs.addRow(data);
                }
            }
        }catch(SQLException e1) {
            System.out.println(e1);
        }
        return moreSongs;
    }




}