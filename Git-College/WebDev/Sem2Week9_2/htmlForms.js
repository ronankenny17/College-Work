function eventHandler()
{
    var email = document.getElementById("emailInput").value;
    var textbox = document.getElementById("textArea1").value;
    var name = document.getElementById("nameInput").value;


   var verifiedEmail = checker(email,"@",".");
        if(verifiedEmail==false)
        {
            window.alert("not a valid email");
        }

    // these if statements check if text was entered into the other text areas
        if(textbox== "")
        {
            alert("please enter text in textbox!");
        }
        if(name == "" )
        {
            alert("please enter your name!")
        }

}

// function to check if email is valid
function checker (textInput ,delimiter1 , delimiter2 )
{
    var verified = false;
    var verifiedFullstop = false;
    var verifiedAt = false;

    // loop will iterate through email and check for @ and .
    // when it finds one it sets the variables for that character to true
    // finally if both variables for the delims are true that means @ and . are both present
    // so the variable verified is then set to true and this is returned by the function
    for(var i = 0 ; i <textInput.length; i++ )
    {
        if(textInput[i] == delimiter1)
        {
           verifiedAt = true;
        }
        if(textInput[i] == delimiter2 )
        {
            verifiedFullstop = true;
        }

    }
    // essentially checks if both @ and . are present -> true if they both are and false if they aren't or only one is present
    if(verifiedAt == true && verifiedFullstop == true )
    {
        verified = true;
    }

    return verified;
}