promesa();
function promesa() {
  const promise = new Promise((resolve, reject) => {
    const request = new XMLHttpRequest();
    request.open('GET', 'https://reqres.in/api/users/3');
    request.onload = () => {
      if (request.status === 200) {//200 BO
        resolve(request.response);
      } else {
        reject(Error(request.statusText));
      }
    };
    request.onerror = () => {
    reject(Error('ERROR PROMESA DECLINADA.'));
    };
    request.send(); // send the request
    });
    promise.then((data) => {
      for (var i in JSON.parse(data).data) {
        console.log(JSON.parse(data).data[i]);
      }
    });

  }
// https://reqres.in/api/users/3

var arrayCosMissatges = [];

// var setCosMissatges = new Set(arrayCosMissatges);
  // new Set(iterable) – creates the set, and if an iterable object is provided (usually an array), copies values from it into the set.
  // set.add(value) – adds a value, returns the set itself.
  // set.delete(value) – removes the value, returns true if value existed at the moment of the call, otherwise false.
  // set.has(value) – returns true if the value exists in the set, otherwise false.
  // set.clear() – removes everything from the set.
  // set.size – is the elements count.
var mapUsuaris = new Map();
class Persona {
  constructor(nom,cognom) {
    this.nom = nom;
    this.cognom = cognom;
  }
  retornarNomComplet(){
    return (this.nom +" "+this.cognom);
  }
  alertText(text){
    alert(text);

  }
}
class Usuari extends Persona{
  retornarNomComplet(){
    return super.retornarNomComplet();
  }
  alertarNom(){
    super.alertText(super.retornarNomComplet());
  }
}

class Missatge{                                       //Herencia amb Objectes -

  constructor(emissor, cosMsg){
    this.emissor = emissor;
    if (cosMsg == null) cosMsg = "!-Missatge buit.-!"

    arrayCosMissatges.push(this.cosMsg);
    mapUsuaris.set(this.emissor,arrayCosMissatges[arrayCosMissatges.length]);

    this.cosMsg = cosMsg;
    console.log("objecte creada");
  }
  retornaPrimerEleArray(){
    return arrayCosMissatges[0];
  }
  ordenarMissatges(){//DESODENA EL MAP!!
    arrayCosMissatges.sort();
  }
  redoListMsg(){
    mapUsuaris.delete(arrayCosMissatges[arrayCosMissatges.length]);
    return arrayCosMissatges.pop();
  }
  existsOwner(usuari){
    return mapUsuaris.has(usuari);
  }


}
// var msg = new Missatge("Pepito","Fulanito",null)



(function() {
  var Message;

  Message = function(arg) {
    this.text = styleMessage(arg.text), this.message_side = arg.message_side;
    this.draw = function(_this) {
      return function() {
        var $message;
        $message = $($('.message_template').clone().html());
        $message.addClass(_this.message_side).find('.text').html(_this.text);
        $('.messages').append($message);
        return setTimeout(function() {
          return $message.addClass('appeared');
        }, 0);
      };
    }(this);
    return this;
  };

  $(function() {
    var getMessageText, message_side, sendMessage;
    message_side = 'right';
    getMessageText = function() {
      var $message_input;
      $message_input = $('.message_input');
      return $message_input.val();
    };
    sendMessage = function(msg) {
      var today = new Date();
      var dd = String(today.getDate()).padStart(2, '0');
      var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
      var yyyy = today.getFullYear();

      today = mm + '/' + dd + '/' + yyyy;
      var text = msg.cosMsg+"~Enviat el "+today+"| Per "+document.getElementById('actualuser').innerHTML+".";
      var $messages, message;
      if (text.trim() === '') {
        return;
      }
      $('.message_input').val('');
      $messages = $('.messages');
      message_side = 'right';
      // message_side = message_side === 'left' ? 'right' : 'left';
      message = new Message({
        text: text,
        message_side: message_side
      });
      message.draw();
      return $messages.animate({
        scrollTop: $messages.prop('scrollHeight')
      }, 300);
    };
    loadMessageDB = function(text) {
      var $messages, message;
      if (text.trim() === '') {
        return;
      }
      $('.message_input').val('');
      $messages = $('.messages');
      message_side = 'left';
      // message_side = message_side === 'left' ? 'sright' : 'left';
      message = new Message({
        text: text,
        message_side: message_side
      });
      message.draw();
      return $messages.animate({
        scrollTop: $messages.prop('scrollHeight')
      }, 300);
    };
    $('.send_message').click(function(e) {
      var emissor = document.getElementById('actualuser').innerHTML;
      var dadesUsuari = emissor.trim().split(" ");
      
      var user = new Usuari(dadesUsuari[0],dadesUsuari[1]);

      user.alertarNom();
      var msg = new Missatge(user.retornarNomComplet(),getMessageText())
      return sendMessage(msg);
    });
    $('.message_input').keyup(function(e) {
      if (e.which === 13) {
        return sendMessage(getMessageText());
      }
    });
    loadMessages();
    console.log("im working");
    function loadMessages() {
      var loadMssg = document.getElementById('missatgesbd').innerHTML;

      loadMssg = loadMssg.split(";");
      for (var i = 0; i < loadMssg.length; i++) {
        if (loadMssg[i].includes(document.getElementById('actualuser').innerHTML.trim())) {
          // sendMessage(loadMssg[i]);
          var arg = loadMssg[i].split("|");
          var msg = new Missatge(arg[1],arg[0]);
          sendMessage(msg);

          // console.log("surot");
        } else {
          loadMessageDB(loadMssg[i]);
        }

      }
    }
  });
}.call(this));



function styleMessage(text) {
  var messg = "";
  var data = "";
  var messgmode = true;
  for (var i = 0; i < text.length; i++) {
    var charAtNow = text.charAt(i);
    if (charAtNow == "~") {
      messgmode = false;
      continue;
    }
    if (messgmode) {
      messg += charAtNow;
      continue;
    }
    data += charAtNow;

  }
  return messg + "<p class='metadata'>" + data + "</p>";

}
