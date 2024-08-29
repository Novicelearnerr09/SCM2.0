console.log("script loaded");

let currentTheme=getTheme();

document.addEventListener('DOMContentLoaded', () => {
    changeTheme();
})

console.log(currentTheme);
//initial them


function changeTheme()
{
    //set to web page
changePageTheme(currentTheme, currentTheme);

const oldTheme=currentTheme;

 //   document.querySelector('html').classList.add(currentTheme);

    //set the listener to change them via button
   const changeThemeButton= document.querySelector('#theme_change_button');
   changeThemeButton.addEventListener
   ("click", (event) => 
    {
            const oldTheme= currentTheme;
            //logic will be written here
            console.log("change theme button clicked");
            
            if(currentTheme=="dark")
            {
                //theme ko light
                currentTheme="light";
            }
            else{
                //theme ko dark
                currentTheme="dark";
            }

            changePageTheme(currentTheme, oldTheme)


   }
    );
}

//set them to localstorage
function setTheme(theme)
{
    
   return localStorage.setItem("theme",theme);
}

//get them from localstorage
function getTheme(){
    let theme= localStorage.getItem("theme");
    if(theme)
    {
        return theme;
    }
    else return "light";

    // return theme ? theme : "light"; 

}

//change current page theme
function changePageTheme(theme, oldTheme)
{
//localstorage mein update karenge

setTheme(currentTheme);
//remove the old theme
document.querySelector('html').classList.remove(oldTheme);
//set the current theme
document.querySelector('html').classList.add(theme);
//change the text of button
document.querySelector('#theme_change_button').querySelector("span").textContent = theme == "light" ?"Dark":"light";
}

