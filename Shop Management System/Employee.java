import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import Classes.*;
import static javax.swing.JOptionPane.showMessageDialog;


public class Employee extends  JFrame implements ActionListener,MouseListener
{

    ImageIcon icon;
    JLabel  frameImage,sms,empName,hPage,employeeName,empsalary,employeeID,label1,rmvemp,srcemp;
    JPanel leftPanel,topPanel;
    JButton addButton, backButton,deleteButton,searchButton,hideButton;
    JTextField employeeIDTF,employeeSalaryTF,employeeNameTF,removeemployee;
    Font font;
    JTable table;

    String [] cols = {"Name","ID","Salary"};

    String [][] rows ={};

    JScrollPane jScrollPane1;
    DefaultTableModel model = new DefaultTableModel(rows,cols);

    Shop s;

    EmployeeC employee[]=new EmployeeC[50];
    EmployeeC emp;


    
    public Employee(String adminUsername,Shop s)
    {

        
        this.s =s;
        

        font = new Font("Arial Rounded MT Bold", 0, 18);

        this.setTitle("Shop Management System");
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        leftPanel = new JPanel();
        leftPanel.setBounds(0,0,280,800);
        leftPanel.setBackground(new Color(0,204,0));
        leftPanel.setLayout(null);
        this.add(leftPanel);


        topPanel = new JPanel();
        topPanel.setBounds(280,30,920,150);
        topPanel.setBackground(new Color(0, 204, 0));
        topPanel.setLayout(null);
        this.add(topPanel);



        hPage = new JLabel("Employee page" );
        hPage.setBounds(30, 50, 300, 45);
        hPage.setForeground(new Color(204, 204, 204));
        hPage.setFont(new Font("Segoe UI Emoji",0,14));
        leftPanel.add(hPage);
        this.add(leftPanel);


        ImageIcon icon =new ImageIcon("Image/iconmonstr-marketing-5-240 (1).png");
        frameImage = new JLabel(icon);
        frameImage.setBounds(0,300,280,400);
        leftPanel.add(frameImage);
        this.add(leftPanel);

        label1 = new JLabel("Shop Management System" );
        label1.setBounds(300, 0, 300, 30);
        label1.setForeground(new Color(0,0,51));
        label1.setFont(new Font("Arial Rounded MT Bold", 0, 14));
        this.add(label1);



        employeeName = new JLabel("Employee Name " );
        employeeName.setBounds(300, 200, 200, 40);
        employeeName.setForeground(new Color(0,0,51));
        employeeName.setFont(font);
        this.add(employeeName);

        employeeNameTF = new JTextField();
        employeeNameTF.setBounds(500, 205, 150, 25);
        employeeNameTF.setForeground(new Color(0,0,51));
        employeeNameTF.setFont(font);
        employeeNameTF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        this.add(employeeNameTF);

        

        employeeID = new JLabel("Employee ID " );
        employeeID.setBounds(300, 240, 200, 40);
        employeeID.setForeground(new Color(0,0,51));
        employeeID.setFont(font);
        this.add(employeeID);


        employeeIDTF = new JTextField();
        employeeIDTF.setBounds(500, 245, 150, 25);
        employeeIDTF.setForeground(new Color(0,0,51));
        employeeIDTF.setFont(font);
        employeeIDTF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        this.add(employeeIDTF);


        empsalary = new JLabel("Employee Salary " );
        empsalary.setBounds(300, 280, 200, 40);
        empsalary.setForeground(new Color(0,0,51));
        empsalary.setFont(font);
        this.add(empsalary);


        employeeSalaryTF = new JTextField();
        employeeSalaryTF.setBounds(500, 285, 150, 25);
        employeeSalaryTF.setForeground(new Color(0,0,51));
        employeeSalaryTF.setFont(font);
        employeeSalaryTF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        this.add(employeeSalaryTF);



        sms = new JLabel("Welcome to "+adminUsername );
        sms.setBounds(180, 50, 500, 45);
        sms.setForeground(new Color(205, 205, 205));
        sms.setFont(new Font("Arial Rounded MT Bold", 0, 32));
        topPanel.add(sms);
        this.add(topPanel);



        backButton = new JButton("Back");
        backButton.setBounds(870, 720, 85, 35);
        backButton.setBackground(new Color(0, 204, 0));
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setFont(font);
        backButton.setFocusable(false);
        backButton.addMouseListener(this);
        backButton.addActionListener(this);
        this.add(backButton);

        hideButton = new JButton("Hide");
        hideButton.setBounds(780, 720, 85, 35);
        hideButton.setBackground(new Color(0, 204, 0));
        hideButton.setForeground(new Color(255, 255, 255));
        hideButton.setFont(font);
        hideButton.setFocusable(false);
        hideButton.addMouseListener(this);
        hideButton.addActionListener(this);
        this.add(hideButton);




        addButton = new JButton("ADD");
        addButton.setBounds(300, 330, 85, 35);
        addButton.setBackground(new Color(0, 204, 0));
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setFont(font);
        addButton.setFocusable(false);
        addButton.addMouseListener(this);
        addButton.addActionListener(this);
        this.add(addButton);



        deleteButton = new JButton("Delete");
        deleteButton.setBounds(430, 440, 100, 35);
        deleteButton.setBackground(new Color(0, 204, 0));
        deleteButton.setForeground(new Color(255, 255, 255));
        deleteButton.setFont(font);
        deleteButton.setFocusable(false);
        deleteButton.addMouseListener(this);
        deleteButton.addActionListener(this);
        this.add(deleteButton);

        searchButton = new JButton("Search");
        searchButton.setBounds(300, 440, 100, 35);
        searchButton.setBackground(new Color(0, 204, 0));
        searchButton.setForeground(new Color(255, 255, 255));
        searchButton.setFont(font);
        searchButton.setFocusable(false);
        searchButton.addMouseListener(this);
        searchButton.addActionListener(this);
        this.add(searchButton);




        table = new JTable(model);
        table.setFont(new Font("Arial Rounded MT Bold", 0, 14));
        table.setForeground(new Color(0,0,51));
        table.setGridColor(new Color(255,255,255));


        jScrollPane1 =new JScrollPane(table);
        jScrollPane1.setBounds(300,500,600,200);
        this.add(jScrollPane1);

        rmvemp = new JLabel("Search Employee " );
        rmvemp.setBounds(300, 400, 250, 40);
        rmvemp.setForeground(new Color(0,0,51));
        rmvemp.setFont(font);
        this.add(rmvemp);

        removeemployee = new JTextField();
        removeemployee.setBounds(500, 410, 150, 25);
        removeemployee.setForeground(new Color(0,0,51));
        removeemployee.setFont(font);
        removeemployee.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        this.add(removeemployee);




    }
    public void insertEmployee(String name,String empid,String salary)
    {
        int flag =0;
        emp = new EmployeeC(name,empid,salary);
        for(int i=0; i<employee.length; i++)
        { 
            if(employee[i] == null)
            {
                employee[i] = emp;
                flag = 1;
                break;

            }

        }

        if(flag == 1){JOptionPane.showMessageDialog(null, "Employee Successfully Inserted!");}
        else  {JOptionPane.showMessageDialog(null, "Unsuccesful Operation!");}
    }
    
    public void removeEmployee(String empname)
    {
        int flag = 0;
        try
        {
            for(int i=0; i<employee.length; i++)
            {
                if(employee[i].getEmployeeName().equals(empname))
                {
                    employee[i] = null;
                    flag = 1;
                    break;
                }
            }
            if(flag == 1)
                {JOptionPane.showMessageDialog(null, "Deletion Successful!");}

            else 
                {JOptionPane.showMessageDialog(null, "Unsuccesful operation!");}
        }
        catch(NullPointerException ne)
        {
         JOptionPane.showMessageDialog(null, "Error Found!"); 
     }

     }


 public EmployeeC searchEmployee(String empname)
 {
    EmployeeC e = null;
     for(int i=0; i<employee.length; i++)
    {
        if(employee[i] != null)
        {
            if(employee[i].getEmployeeName().equals(empname))
            {
                e=employee[i];
                break;
            }
        }
     }
    if(e != null)
    {
        JOptionPane.showMessageDialog(null, "Employee Not Found!");
    }
    else
    {
        JOptionPane.showMessageDialog(null, "Employee  Found!");
    }

    
    
    return e;

}






public void mouseClicked(MouseEvent me){}
public void mousePressed(MouseEvent me){}
public void mouseReleased(MouseEvent me){}
public void mouseEntered(MouseEvent me)
{
    if(me.getSource() == addButton)
    {
        addButton.setBackground(Color.WHITE);
        addButton.setForeground(new Color(0, 204, 0));
    }
    else if(me.getSource() == backButton)
    {
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(new Color(0, 204, 0));
    }
    else if(me.getSource() == deleteButton)
    {
        deleteButton.setBackground(Color.WHITE);
        deleteButton.setForeground(new Color(0, 204, 0));
    }
    else if(me.getSource() == searchButton)
    {
        searchButton.setBackground(Color.WHITE);
        searchButton.setForeground(new Color(0, 204, 0));
    }
    else if(me.getSource() == hideButton)
    {
        hideButton.setBackground(Color.WHITE);
        hideButton.setForeground(new Color(0, 204, 0));
    }


    else
    {

    }
}
public void mouseExited(MouseEvent me)
{
    if(me.getSource() == addButton)
    {
        addButton.setBackground(new Color(0, 204, 0));
        addButton.setForeground(new Color(255, 255, 255));
    }

    else if(me.getSource() == backButton)
    {

        backButton.setBackground(new Color(0, 204, 0));
        backButton.setForeground(new Color(255, 255, 255));

    }
    else if(me.getSource() == deleteButton)
    {

        deleteButton.setBackground(new Color(0, 204, 0));
        deleteButton.setForeground(new Color(255, 255, 255));

    }
    else if(me.getSource() == searchButton)
    {

        searchButton.setBackground(new Color(0, 204, 0));
        searchButton.setForeground(new Color(255, 255, 255));

    }
    else if(me.getSource() == hideButton)
    {
      hideButton.setBackground(new Color(0, 204, 0));
      hideButton.setForeground(new Color(255, 255, 255));

  }


  else
  {

  }
}




public void actionPerformed(ActionEvent e)

{
String rmve= removeemployee.getText();
DefaultTableModel model = (DefaultTableModel)table.getModel();

   if (e.getSource() == backButton)
   {


    String adminUsername = s.usernameField.getText();

    Homepage h = new Homepage(adminUsername,s);

    Management m = new Management(s,h,this);
    m.setVisible(true);
    this.setVisible(false);


   }

if(e.getSource() == addButton)
{


    String a = employeeNameTF.getText();
    String b = employeeIDTF.getText();
    String c = employeeSalaryTF.getText();


    


    try
    {
        if (a.length() != 0 && b.length() != 0 && c.length() != 0)
        {
            model.addRow(new Object []{a,b,c});

            employeeNameTF.setText("");
            employeeIDTF.setText("");
            employeeSalaryTF.setText("");
            insertEmployee(a,b,c);
        }
         else
        {
            throw new TextfieldException();

        }
    }

    catch (TextfieldException te)
    {
        showMessageDialog(null,te.getMessage());
    }
}

if(e.getSource() == deleteButton)
{



    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
    table.setRowSorter(tr);

    if(rmve.length() != 0)
{
    try
    {
    tr.setRowFilter(RowFilter.regexFilter(rmve));
    table.setRowSelectionInterval(0, 0);
    int row = table.getSelectedRow();
    model.removeRow(row);
    this.removeEmployee(rmve);
    removeemployee.setText("");
     }
     catch(IllegalArgumentException iae)
{
    showMessageDialog(null,"No Employee With This ID");
}


}


}

if(e.getSource() == hideButton)
{
    try
    {

        int row = table.getSelectedRow();    
        model.removeRow(row);
    }

    catch(ArrayIndexOutOfBoundsException aio)
    {
        showMessageDialog(null,"No Employee Selected");
    }


}
if(e.getSource() == searchButton)
{
    
    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
    table.setRowSorter(tr);
if(rmve.length() != 0)
{
try
   {
   tr.setRowFilter(RowFilter.regexFilter(rmve));

    table.setRowSelectionInterval(0, 0);
    searchEmployee(rmve);
}
catch(IllegalArgumentException iae)
{
    showMessageDialog(null,"No Employee With This ID");
}
}



}

else{}
}





}


