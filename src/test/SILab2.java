import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    public List<User> setList(){
        List<User> list = new ArrayList<>();

        return list;
    }

    @Test
    void multipleCondition(){
        RuntimeException ex;
        //T X X -> user == null
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null,setList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //F T X -> user.getPassword() == null
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("sergej",null,"sergej@finki.com"),setList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //F F T -> user.getEmail() == null
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("sergej","Norski123!?!",null),setList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //F F F -> dokolku site informacii se OK i ne vleguva vo IF
        assertTrue(SILab2.function(new User("sergej","Norski123!?","sergej@finki.com"),setList()));
    }

    @Test
        //when user == null then it should throw exception (cover branch : password==null / email==null)
    void nullUser_ThrowException(){
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null,setList()));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }

    @Test
        //when username == null then it should set the username same as mail and password.Lenght < 8
    void nullUsername_SetEmailAsUsername(){
        User user = new User(null,"Norsk1!","sergej@finki.com");
        SILab2.function(user,setList());
        assertEquals(user.getUsername(),user.getEmail());
        assertFalse(SILab2.function(user,setList()));
    }

    @Test
    void existingUsernameAndEmail(){
        User user1 = new User("sergej","sergej","sergej@finki.com");
        User userduplicate1 = new User("sergej","sergej","norski@finki.com");
        User userduplicate2 = new User("norski","sergej","sergej@finki.com");

        setList().add(userduplicate1);
        setList().add(userduplicate2);

        assertFalse(SILab2.function(user1,setList()));
    }

    @Test
        //when mail doesn't contain . or @
    void mailNotCorrect(){
        User user = new User("sergej","Norski123?!","sergejfinkicom");
        assertFalse(SILab2.function(user,setList()));
    }

    @Test
        //when user password doesn't have " " and has special char
    void correctPassword(){
        User user = new User("sergej","Norski123?!","sergej@finki.com");
        assertTrue(SILab2.function(user,setList()));
    }

    @Test
        //when user has " " in password
    void passwordNotCorrect(){
        User user = new User("sergej","Norski 23?!","sergej@finki.com");
        assertFalse(SILab2.function(user,setList()));
    }



}