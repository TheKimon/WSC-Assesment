package WSC;


import java.awt.CardLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author Kimon Konstantinou
 */


class login extends Menu{
    
    private String username;
    private String password;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    
    private static Scanner x;

    
    String verify(){
      

      
      
       boolean found = false;
       
       String tempUsername = "";
       String tempPassword = "";

       try{
          x = new Scanner(new File("login.txt"));
          x.useDelimiter("[,\n]");
          
            while(x.hasNext()){
              
              tempUsername = x.next();
              tempPassword = x.next();
              status = x.next();
               

              
              if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())){


                 return status;
              }
            } 
          x.close();
          System.out.println(found);
        }
       catch(Exception e){
           System.out.println("Error");
        }
       
       return "";
       
    }   

}


class userInformation extends login{
    private static Scanner x;
    private boolean found;
    
    private String tempUsername = "";
    private String tempName;
    private String tempID;
    private String tempAdress;
    private String tempTelep ;
    private String tempStatus;
    private String Username;
    
    
    public boolean isFound() {
        return found;
    }

    public String getTempUsername() {
        return tempUsername;
    }

    public String getTempName() {
        return tempName;
    }

    public String getTempID() {
        return tempID;
    }

    public String getTempAdress() {
        return tempAdress;
    }

    public String getTempTelep() {
        return tempTelep;
    }

    public String getTempStatus() {
        return tempStatus;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public void setTempUsername(String tempUsername) {
        this.tempUsername = tempUsername;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public void setTempID(String tempID) {
        this.tempID = tempID;
    }

    public void setTempAdress(String tempAdress) {
        this.tempAdress = tempAdress;
    }

    public void setTempTelep(String tempTelep) {
        this.tempTelep = tempTelep;
    }

    public void setTempStatus(String tempStatus) {
        this.tempStatus = tempStatus;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void infoCollect(){


 
       try{
          x = new Scanner(new File("personalinformation.txt"));
          x.useDelimiter("[,\n]");
           
            while(x.hasNext()&&!tempUsername.trim().equals(Username.trim())){
              
              tempUsername = x.next();

            }  
              if(tempUsername.trim().equals(Username.trim())){
              tempName = x.next();
              tempID = x.next();
              tempAdress = x.next();
              tempTelep = x.next();
              tempStatus = x.next();
              this.found = true;     
              } 

          x.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
        
    }   
   
}


class teams extends login{
   
private static Scanner x;    

@Override
public void setUsername(String username) {
   this.username = username;
 }
public String team;
private String username;
public String School;
public String Subject;

private String studentA;
private String studentB;    
private String studentC; 
private String studentD;  
private String coach;
private String coachUsername;

private String marks;

    public String getTeam() {
        return team;
    }

    public String getSchool() {
        return School;
    }

    public String getSubject() {
        return Subject;
    }

    public String getStudentA() {
        return studentA;
    }

    public String getStudentB() {
        return studentB;
    }

    public String getStudentC() {
        return studentC;
    }

    public String getStudentD() {
        return studentD;
    }

    public String getCoach() {
        return coach;
    }

    public String getCoachUsername() {
        return coachUsername;
    }

    public String getMarks() {
        return marks;
    }
    
    

public void teamFinder(){
    boolean found = false;
       
       try{
          x = new Scanner(new File("teams.txt"));
          x.useDelimiter("[,\n]");
           
            while(x.hasNext()&& found != true){
             
             team = x.next();
             School = x.next();
             Subject = x.next();
             studentA = x.next(); 
             studentB = x.next();    
             studentC = x.next(); 
             studentD = x.next();
             marks = x.next();
             coach = x.next();
             coachUsername = x.next();

                
              if(username.trim().equals(coachUsername.trim()) || username.trim().equals(studentA.trim()) || username.trim().equals(studentB.trim()) || username.trim().equals(studentC.trim()) || username.trim().equals(studentD.trim())){
                
                 found = true;
              } 
              
            }
          x.close();
           System.out.println("end");
        }
        catch(Exception e){
            System.out.println("Error");
        }
        
    }   
   
  
}




class judgeViewTeams extends Menu{
    
private static Scanner x;  
private String team;
private String username;

public String School;
public String Subject;

private String marks;
private String studentA;
private String studentB;    
private String studentC; 
private String studentD;  
private String coach;
private String coachUsername;


String[] teamContainer = new String[6];

 
   String[] collectInformation(){
    
    String teamInfo = "login.txt"; 
    Boolean found = false;
    

       try{
         
          x = new Scanner(new File(teamInfo));
          x.useDelimiter("[,\n]");
          
            int i = 0; 
            
            while(x.hasNext()){

             team = x.next();
             School = x.next();
             Subject = x.next();
             studentA  = x.next(); 
             studentB = x.next();    
             studentC = x.next(); 
             studentD = x.next();
             marks = x.next();
             coach = x.next();
             coachUsername = x.next();
            
             
             teamContainer[i]= studentA+","+team+","+School+","+Subject+","+","+marks;

             i++;
           
                if(x.hasNext() != true){ 
                    
                    found = true;
                    setTeamContainer(teamContainer);
                    //              or
                    //teamContainer = teamContainer;
                }              
            }
          x.close();
           System.out.println("end");
           
        }
        catch(Exception e){
            System.out.println("Error");
        }
       
    return teamContainer;

    } 
    
      public String[] getTeamContainer() {
        return teamContainer.clone();
    }  

    public void setTeamContainer(String[] teamContainer) {
        this.teamContainer = teamContainer;
    }
      
    
}










public class Menu extends javax.swing.JFrame {
 
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }
  


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        mainMenu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        StudentButton = new javax.swing.JButton();
        coachButton = new javax.swing.JButton();
        JudgeButton = new javax.swing.JButton();
        coachPanel = new javax.swing.JPanel();
        coachTitle = new javax.swing.JLabel();
        coachUsername = new javax.swing.JLabel();
        coachPassword = new javax.swing.JLabel();
        coachUserInput = new javax.swing.JTextField();
        coachPassInput = new javax.swing.JTextField();
        coachLogin = new javax.swing.JButton();
        coachBack = new javax.swing.JButton();
        studentPanel = new javax.swing.JPanel();
        StudentTitle = new javax.swing.JLabel();
        StudentUsername = new javax.swing.JLabel();
        StudentPassword = new javax.swing.JLabel();
        studentUserInput = new javax.swing.JTextField();
        studentPassInput = new javax.swing.JTextField();
        studentLogin = new javax.swing.JButton();
        studentBack = new javax.swing.JButton();
        judgePanel = new javax.swing.JPanel();
        judgeTitle1 = new javax.swing.JLabel();
        judgeUsername1 = new javax.swing.JLabel();
        judgePassword1 = new javax.swing.JLabel();
        judgeUserInput1 = new javax.swing.JTextField();
        judgePassInput1 = new javax.swing.JTextField();
        judgeLogin1 = new javax.swing.JButton();
        judgeBack1 = new javax.swing.JButton();
        studentMenu = new javax.swing.JPanel();
        studentNamelb = new javax.swing.JLabel();
        studentName = new javax.swing.JLabel();
        studentIDlb1 = new javax.swing.JLabel();
        studentID = new javax.swing.JLabel();
        studentAdresslb = new javax.swing.JLabel();
        studentAdress = new javax.swing.JLabel();
        studentTelephonelb = new javax.swing.JLabel();
        studentTelephone = new javax.swing.JLabel();
        studentStatuslb = new javax.swing.JLabel();
        StudentStatus = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        logOut = new javax.swing.JButton();
        teamView = new javax.swing.JButton();
        judgeMenu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        judgeTable = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        teamPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        teamaIDlb = new javax.swing.JLabel();
        teamaID = new javax.swing.JLabel();
        memberA = new javax.swing.JLabel();
        memberB = new javax.swing.JLabel();
        memberC = new javax.swing.JLabel();
        memberD = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        coachName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        teamGrade = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        logOut1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setLayout(new java.awt.CardLayout());

        jLabel2.setText("Please click one of the following options");

        StudentButton.setText("Student");
        StudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentButtonActionPerformed(evt);
            }
        });

        coachButton.setText("Coach");
        coachButton.setToolTipText("");
        coachButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachButtonActionPerformed(evt);
            }
        });

        JudgeButton.setText("Judge");
        JudgeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JudgeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(coachButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JudgeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(235, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(StudentButton)
                .addGap(11, 11, 11)
                .addComponent(coachButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JudgeButton)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainMenuLayout = new javax.swing.GroupLayout(mainMenu);
        mainMenu.setLayout(mainMenuLayout);
        mainMenuLayout.setHorizontalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainMenuLayout.setVerticalGroup(
            mainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MainPanel.add(mainMenu, "mainpanel");

        coachTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coachTitle.setText("Coach Login");

        coachUsername.setText("Username");

        coachPassword.setText("Password");

        coachUserInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachUserInputActionPerformed(evt);
            }
        });

        coachLogin.setText("Login");
        coachLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachLoginActionPerformed(evt);
            }
        });

        coachBack.setText("Back");
        coachBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coachPanelLayout = new javax.swing.GroupLayout(coachPanel);
        coachPanel.setLayout(coachPanelLayout);
        coachPanelLayout.setHorizontalGroup(
            coachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachPanelLayout.createSequentialGroup()
                .addGroup(coachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coachPanelLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(coachTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(coachBack)
                    .addGroup(coachPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(coachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(coachPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coachUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(coachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(coachUserInput, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(coachPassInput)))
                    .addGroup(coachPanelLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(coachLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(281, Short.MAX_VALUE))
        );
        coachPanelLayout.setVerticalGroup(
            coachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(coachTitle)
                .addGap(18, 18, 18)
                .addGroup(coachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachUsername)
                    .addComponent(coachUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(coachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachPassword)
                    .addComponent(coachPassInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(coachLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(coachBack))
        );

        MainPanel.add(coachPanel, "coachpanel");

        StudentTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StudentTitle.setText("Student Login");

        StudentUsername.setText("Username");

        StudentPassword.setText("Password");

        studentUserInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentUserInputActionPerformed(evt);
            }
        });

        studentLogin.setText("Login");
        studentLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentLoginActionPerformed(evt);
            }
        });

        studentBack.setText("Back");
        studentBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentPanelLayout = new javax.swing.GroupLayout(studentPanel);
        studentPanel.setLayout(studentPanelLayout);
        studentPanelLayout.setHorizontalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentPanelLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(StudentTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(studentBack)
                    .addGroup(studentPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(StudentPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StudentUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(studentUserInput, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(studentPassInput)))
                    .addGroup(studentPanelLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(studentLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(281, Short.MAX_VALUE))
        );
        studentPanelLayout.setVerticalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(StudentTitle)
                .addGap(18, 18, 18)
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentUsername)
                    .addComponent(studentUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentPassword)
                    .addComponent(studentPassInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(studentLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(studentBack))
        );

        MainPanel.add(studentPanel, "studentpanel");

        judgeTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judgeTitle1.setText("Judge Login");

        judgeUsername1.setText("Username");

        judgePassword1.setText("Password");

        judgeUserInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judgeUserInput1ActionPerformed(evt);
            }
        });

        judgeLogin1.setText("Login");
        judgeLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judgeLogin1ActionPerformed(evt);
            }
        });

        judgeBack1.setText("Back");
        judgeBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judgeBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout judgePanelLayout = new javax.swing.GroupLayout(judgePanel);
        judgePanel.setLayout(judgePanelLayout);
        judgePanelLayout.setHorizontalGroup(
            judgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judgePanelLayout.createSequentialGroup()
                .addGroup(judgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(judgePanelLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(judgeTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(judgeBack1)
                    .addGroup(judgePanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(judgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(judgePassword1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(judgeUsername1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(judgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(judgeUserInput1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(judgePassInput1)))
                    .addGroup(judgePanelLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(judgeLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(281, Short.MAX_VALUE))
        );
        judgePanelLayout.setVerticalGroup(
            judgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judgePanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(judgeTitle1)
                .addGap(18, 18, 18)
                .addGroup(judgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(judgeUsername1)
                    .addComponent(judgeUserInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(judgePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(judgePassword1)
                    .addComponent(judgePassInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(judgeLogin1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(judgeBack1))
        );

        MainPanel.add(judgePanel, "judgepanel");

        studentNamelb.setText("Name");
        studentNamelb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        studentName.setBackground(new java.awt.Color(204, 255, 204));
        studentName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        studentIDlb1.setText("ID");
        studentIDlb1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        studentID.setBackground(new java.awt.Color(204, 255, 204));
        studentID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        studentAdresslb.setText("Address");
        studentAdresslb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        studentAdress.setBackground(new java.awt.Color(204, 255, 204));
        studentAdress.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        studentTelephonelb.setText("Telephone");
        studentTelephonelb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        studentTelephone.setBackground(new java.awt.Color(204, 255, 204));
        studentTelephone.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        studentStatuslb.setText("Status");
        studentStatuslb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        StudentStatus.setBackground(new java.awt.Color(204, 255, 204));
        StudentStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        logOut.setText("Log Out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        teamView.setText("View Team");
        teamView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentMenuLayout = new javax.swing.GroupLayout(studentMenu);
        studentMenu.setLayout(studentMenuLayout);
        studentMenuLayout.setHorizontalGroup(
            studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentMenuLayout.createSequentialGroup()
                .addGroup(studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, studentMenuLayout.createSequentialGroup()
                        .addGroup(studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(studentMenuLayout.createSequentialGroup()
                                .addGroup(studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentNamelb, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(studentAdresslb, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(studentMenuLayout.createSequentialGroup()
                                .addComponent(studentTelephonelb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(61, 61, 61)))
                        .addGroup(studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(studentName, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(studentAdress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentTelephone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, studentMenuLayout.createSequentialGroup()
                        .addComponent(studentStatuslb, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addComponent(StudentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(studentMenuLayout.createSequentialGroup()
                        .addComponent(studentIDlb1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(studentID, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(studentMenuLayout.createSequentialGroup()
                        .addComponent(logOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(teamView, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        studentMenuLayout.setVerticalGroup(
            studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentNamelb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentIDlb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentAdresslb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(studentTelephonelb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(studentTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(teamView))
                .addGap(18, 18, 18)
                .addGroup(studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(logOut)
                        .addComponent(jButton1))
                    .addGroup(studentMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(studentStatuslb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(StudentStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        MainPanel.add(studentMenu, "studentmenu");

        judgeMenu.setPreferredSize(new java.awt.Dimension(463, 285));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        judgeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Team ID", "Institution", "Field", "Marks"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        judgeTable.setToolTipText("");
        judgeTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(judgeTable);
        judgeTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One of the Options", "Software Development", "Web Development", "Networking" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Judge Menu");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout judgeMenuLayout = new javax.swing.GroupLayout(judgeMenu);
        judgeMenu.setLayout(judgeMenuLayout);
        judgeMenuLayout.setHorizontalGroup(
            judgeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judgeMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(judgeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(judgeMenuLayout.createSequentialGroup()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(246, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        judgeMenuLayout.setVerticalGroup(
            judgeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, judgeMenuLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(judgeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MainPanel.add(judgeMenu, "judgemenu");

        teamPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        teamPanel.setToolTipText("");

        jLabel3.setText("Team Name");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        teamaIDlb.setText("Team ID");
        teamaIDlb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        teamaID.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        memberA.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        memberB.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        memberC.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        memberD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Team Grade");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        coachName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Coach for the team");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        teamGrade.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        logOut1.setText("Log Out");
        logOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout teamPanelLayout = new javax.swing.GroupLayout(teamPanel);
        teamPanel.setLayout(teamPanelLayout);
        teamPanelLayout.setHorizontalGroup(
            teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addGroup(teamPanelLayout.createSequentialGroup()
                        .addComponent(teamaIDlb)
                        .addGap(18, 18, 18)
                        .addComponent(teamaID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(memberA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(memberB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(memberC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(memberD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(teamPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(teamGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(teamPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coachName, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(teamPanelLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(logOut1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        teamPanelLayout.setVerticalGroup(
            teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(teamaID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(teamaIDlb))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teamGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(coachName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(memberA, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(teamPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(memberB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(memberC, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(teamPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(teamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logOut1)
                            .addComponent(jButton3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(memberD, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        MainPanel.add(teamPanel, "teampanel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentButtonActionPerformed
        // TODO add your handling code here:
        
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "studentpanel");
    }//GEN-LAST:event_StudentButtonActionPerformed

    private void studentUserInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentUserInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentUserInputActionPerformed

    private void studentLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentLoginActionPerformed

       
       
       String username = studentUserInput.getText();
       String password = studentPassInput.getText();
       
       teams studentTeam = new teams();
       login newLogin = new login();
       userInformation newInformation = new userInformation();
       
       newLogin.setUsername(username);
       newLogin.setPassword(password);
       newInformation.setUsername(username);
      
       if ("s".equals(newLogin.verify().trim())){

        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "studentmenu");
        
        newInformation.infoCollect();
        
        
        studentName.setText(newInformation.getTempName());
        studentID.setText(newInformation.getTempID()); 
        studentAdress.setText(newInformation.getTempAdress());       
        studentTelephone.setText(newInformation.getTempTelep());   
        StudentStatus.setText(newInformation.getTempStatus());
        
       }
       
       else{
           
           // Add Error Popup
           
       } 
      
      
    }//GEN-LAST:event_studentLoginActionPerformed

    private void studentBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentBackActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "mainpanel");
    }//GEN-LAST:event_studentBackActionPerformed

    private void coachButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachButtonActionPerformed
        // TODO add your handling code here:
        
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "coachpanel");
    }//GEN-LAST:event_coachButtonActionPerformed

    private void coachUserInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachUserInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachUserInputActionPerformed

    private void coachLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachLoginActionPerformed
        
        
       String username = coachUserInput.getText();
       String password = coachPassInput.getText();
       
       login newLogin = new login();
       userInformation newInformation = new userInformation();
       
       
       newLogin.setUsername(username);
       newLogin.setPassword(password);
       newInformation.setUsername(username);
       
 
        
       if ("jc".equals(newLogin.verify().trim()) || "c".equals(newLogin.verify().trim()) ){

        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "teampanel");
        
        teams coachTeam = new teams();
        coachTeam.setUsername(username);
        coachTeam.teamFinder();
        
        memberA.setText(coachTeam.getStudentA());
        memberB.setText(coachTeam.getStudentB());
        memberC.setText(coachTeam.getStudentC());
        memberD.setText(coachTeam.getStudentD());
        coachName.setText(coachTeam.getCoach());
        teamGrade.setText(coachTeam.getMarks());
        teamaID.setText(coachTeam.getTeam());
        
       }
       
       else{
           
       }    
        
        
    }//GEN-LAST:event_coachLoginActionPerformed

    private void coachBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachBackActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "mainpanel");
    }//GEN-LAST:event_coachBackActionPerformed

    private void JudgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JudgeButtonActionPerformed
        // TODO add your handling code here:
        
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "judgepanel");
        
    }//GEN-LAST:event_JudgeButtonActionPerformed

    private void judgeUserInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judgeUserInput1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_judgeUserInput1ActionPerformed

    private void judgeLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judgeLogin1ActionPerformed
       
       String[] teamContainer = new String[6];
       String username = judgeUserInput1.getText();
       String password = judgePassInput1.getText();
       
       login newLogin = new login();

       judgeViewTeams judgeUI = new judgeViewTeams();
       
       newLogin.setUsername(username);
       newLogin.setPassword(password);
       
       
       
       if ("jc".equals(newLogin.verify().trim())){
           
        
        judgeUI.getTeamContainer();
        
        String[] teamGroup = judgeUI.collectInformation();
             
  
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "judgemenu");
        
        
        int x = 0;
        
        
           System.out.println(teamGroup[x]); 
        
    for (int i=0 ;i <= teamGroup.length; i = i+3){
      
        
      String tempHolder1 = teamGroup[x];
        
      String[] newTeamArray = tempHolder1.split(","); 
      
      String team = newTeamArray[1];
      String school = newTeamArray[2];
      String subject = newTeamArray[3];
      String marks = newTeamArray[5];
        
      
        String data1 = team;
        String data2 = school;
        String data3 = subject;
        String data4 = marks;

        Object[] row = { data1, data2, data3, data4};

        DefaultTableModel model = (DefaultTableModel) judgeTable.getModel();

        model.addRow(row);
        
         x++;
        
        
    }
        
       
        
       }
       
       else{
           
       }    

        
    }//GEN-LAST:event_judgeLogin1ActionPerformed

    private void judgeBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judgeBack1ActionPerformed
        // TODO add your handling code here:
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "mainpanel");
        
    }//GEN-LAST:event_judgeBack1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        // TODO add your handling code here:
       login logout = new login(); 
       
       logout.setUsername("");
       logout.setPassword("");
        
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "mainpanel"); 
        
        
        
    }//GEN-LAST:event_logOutActionPerformed

    private void teamViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamViewActionPerformed
        // TODO add your handling code here:
        
        
        
        teams studentTeam = new teams();
        
        studentTeam.teamFinder();
        
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "teampanel");
        
        memberA.setText(studentTeam.getStudentA());
        memberB.setText(studentTeam.getStudentB());
        memberC.setText(studentTeam.getStudentC());
        memberD.setText(studentTeam.getStudentD());
        coachName.setText(studentTeam.getCoach());
        teamGrade.setText(studentTeam.getMarks());
        teamaID.setText(studentTeam.getTeam());
    }//GEN-LAST:event_teamViewActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void logOut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut1ActionPerformed
        // TODO add your handling code here:
        
       login logout = new login();

       logout.setUsername("");
       logout.setPassword("");
        
        
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "mainpanel"); 
        
        
    }//GEN-LAST:event_logOut1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
        
        
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JudgeButton;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton StudentButton;
    private javax.swing.JLabel StudentPassword;
    private javax.swing.JLabel StudentStatus;
    private javax.swing.JLabel StudentTitle;
    private javax.swing.JLabel StudentUsername;
    private javax.swing.JButton coachBack;
    private javax.swing.JButton coachButton;
    private javax.swing.JButton coachLogin;
    private javax.swing.JLabel coachName;
    private javax.swing.JPanel coachPanel;
    private javax.swing.JTextField coachPassInput;
    private javax.swing.JLabel coachPassword;
    private javax.swing.JLabel coachTitle;
    private javax.swing.JTextField coachUserInput;
    private javax.swing.JLabel coachUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton judgeBack1;
    private javax.swing.JButton judgeLogin1;
    private javax.swing.JPanel judgeMenu;
    private javax.swing.JPanel judgePanel;
    private javax.swing.JTextField judgePassInput1;
    private javax.swing.JLabel judgePassword1;
    private javax.swing.JTable judgeTable;
    private javax.swing.JLabel judgeTitle1;
    private javax.swing.JTextField judgeUserInput1;
    private javax.swing.JLabel judgeUsername1;
    private javax.swing.JButton logOut;
    private javax.swing.JButton logOut1;
    private javax.swing.JPanel mainMenu;
    private javax.swing.JLabel memberA;
    private javax.swing.JLabel memberB;
    private javax.swing.JLabel memberC;
    private javax.swing.JLabel memberD;
    private javax.swing.JLabel studentAdress;
    private javax.swing.JLabel studentAdresslb;
    private javax.swing.JButton studentBack;
    private javax.swing.JLabel studentID;
    private javax.swing.JLabel studentIDlb1;
    private javax.swing.JButton studentLogin;
    private javax.swing.JPanel studentMenu;
    private javax.swing.JLabel studentName;
    private javax.swing.JLabel studentNamelb;
    private javax.swing.JPanel studentPanel;
    private javax.swing.JTextField studentPassInput;
    private javax.swing.JLabel studentStatuslb;
    private javax.swing.JLabel studentTelephone;
    private javax.swing.JLabel studentTelephonelb;
    private javax.swing.JTextField studentUserInput;
    private javax.swing.JLabel teamGrade;
    private javax.swing.JPanel teamPanel;
    private javax.swing.JButton teamView;
    private javax.swing.JLabel teamaID;
    private javax.swing.JLabel teamaIDlb;
    // End of variables declaration//GEN-END:variables
}
