import java.io.*;
import javax.swing.*;
class Hider
{
    public static void main(String args[])throws IOException
    {
        JFileChooser ob=new JFileChooser("c:\\");
        ob.showOpenDialog(null);
        File f=ob.getSelectedFile();
        File f2=new File("temp");
        FileInputStream fin=new FileInputStream(f);
        DataInputStream din=new DataInputStream(fin);
        FileOutputStream fout =new FileOutputStream(f2);
        DataOutputStream dout= new DataOutputStream(fout);
        boolean eof=false;
        while(eof==false)
        {
            try
            {
                byte b=din.readByte();
                b=(byte)(b^25);
                dout.writeByte(b);
            }
            catch(EOFException e)
            {
                eof=true;
            }
        }
        dout.close();
        fout.close();
        din.close();
        fin.close();
        f.delete();
        f2.renameTo(f);
    }
}
        
