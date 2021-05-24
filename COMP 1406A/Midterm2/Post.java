
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Post implements Comparable<Post>{
    public User postedBy;
    public Date datePosted;
    public String content;
    public int likes;

    public int compareTo(Post one){
        if(this.datePosted.after(one.datePosted) == true){
            return 1;
        }
        if(one.datePosted.after(this.datePosted) == true){
            return -1;
        }else{
            if(this.likes < one.likes){
                return -1;
            }
            if(this.likes > one.likes){
                return 1;
            }else{
                return 0;
            }
        }
    }
}