<%--
  Created by IntelliJ IDEA.
  User: ihababadi
  Date: 12/12/2022
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../includes/head.jsp" />
<body>
<jsp:include page="../includes/header.jsp" />
<div>
    <form action="/patient/formulaire" method="post" class="container">
        <div class="row justify-content-center m-1">
            <input type="text" class="form-control p-1" name="nss" placeholder="Numéro de sécurité sociale" />
        </div>
        <div class="row justify-content-center m-1">
            <input type="text" class="form-control p-1" name="nom" placeholder="Nom " />
        </div>
        <div class="row justify-content-center m-1">
            <input type="text" class="form-control p-1" name="prenom" placeholder="Prénom " />
        </div>
        <div class="row justify-content-center m-1">
            <input type="date" class="form-control p-1" name="dateNaissance" placeholder="Date de naissance" />
        </div>
        <div class="row justify-content-center m-1">
            <select name="sexe"><option></option><option>Homme</option> <option>Femme</option></select>
        </div>
        <div class="row justify-content-center m-1">
            <input type="text" class="form-control p-1" name="adresse" placeholder="Adresse" />
        </div>
        <div class="row justify-content-center m-1">
            <input type="number" class="form-control p-1" name="telephone" placeholder="Téléphone" />
        </div>
        <div class="row justify-content-center m-1">
            <button class="btn btn-success col" type="submit">Valider</button>
        </div>
    </form>
</div>
</body>
</html>
