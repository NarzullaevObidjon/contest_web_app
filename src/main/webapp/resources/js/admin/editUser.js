let element = document.getElementById("flexSwitchCheckDefault");
let element1 = document.getElementById("flexSwitchCheckChecked");
let textArea = document.getElementById("validationTextarea");
let textAreaValue = textArea.value;
let dateTime = document.getElementById("datetime");
let dateTimeValue = dateTime.value;
element.addEventListener("change", function (event) {
    if (event.target.checked) {
        console.log("checked 1");
        textArea.textContent=textAreaValue;
        dateTime.value = dateTimeValue;
        textArea.disabled = false;
        dateTime.disabled = false;
    } else {
        console.log("not checked 1");
        textArea.textContent="";
        dateTime.value = "";
        textArea.disabled = true;
        dateTime.disabled = true;
    }
});
element1.addEventListener("change", function (event) {
    if (event.target.checked) {
        console.log("checked 2");
        textArea.textContent=textAreaValue;
        dateTime.value = dateTimeValue;
        textArea.disabled = false;
        dateTime.disabled = false;
    } else {
        console.log("not checked 2");
        textArea.textContent="";
        dateTime.value = "";
        textArea.disabled = true;
        dateTime.disabled = true;
    }
});