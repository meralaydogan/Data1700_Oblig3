$(function () {
    biletInfo();
})

function biletInfo() {
    const id = window.location.search.substring(1);
    console.log(id)
    const url = "/hentBiletet?id="+id;
    $.get(url, function (bilet){
        console.log(bilet)
        $("fornavn").val(bilet.fornavn);
        $("etternavn").val(bilet.etternavn);
        $("antall").val(bilet.antall);
        $("telefonnr").val(bilet.telefonNr);
        $("epost").val(bilet.epost);

    })
}
function endreBillett() {
    let bilet={
        filmNavn:$("#valgtFilm").val(),
        antall:$("#antall").val(),
        fornavn:$("#fornavn").val(),
        etternavn:$("#etternavn").val(),
        telefonNr:$("#telefonnr").val(),
        epost:$("#epost").val(),
        id:window.location.search.substring(1)
    }
    console.log(bilet)
    if(checkInput()){
        $.post("/endre", bilet,function () {
            window.location.href="biletTabel.html"
            $("#filmNavn").val("");
            $("#antall").val("");
            $("#fornavn").val("")
            $("#etternavn").val("")
            $("#telefonnr").val("");
            $("#epost").val("");
        })
    }else{
        $("#feilAntalMessage").text('"Må skriv noe inn i antall"');
        $("#feilFornavnMessage").text('"Må skriv noe inn i fornavn"');
        $("#feilEtternavnMessage").text('"Må skriv noe inn i etternavn"');
        $("#feilTelefonNrMessage").text('"Må skriv noe inn i telefonnr"');
        $("#feilEpostMessage").text('"Må skriv noe inn i epost"');
    }
}