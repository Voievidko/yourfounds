<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="YourFounds - it's about money">
  <meta name="author" content="Roman Voievidko">

  <title>YourFounds - it's about money</title>

  <!-- Custom fonts for this template-->
  <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <%@include file="../sidebar.jsp" %>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <%@include file="../topbar.jsp"%>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <div class="p-5">
            <div class="text-left">
              <h1 class="h4 text-gray-900 mb-4">Can't delete category</h1>
              <p>Category <b>${categoryToDelete.name}</b> can't be deleted because it's used by some of your expenses.
                Anyway, if you want to delete it. You can reassign all your expenses to other category.
              Assign all wastes from <b>${categoryToDelete.name}</b> to </p>
            </div>
            <div class="form-group row">

              <div class="col-sm-6 mb-3 mb-sm-0">
                <b>existing category</b><br>
                  <form action="transferToExistCategory">
                      <select name="categoryId" class="form-control">
                        <c:forEach var="tempCategory" items="${categories}">
                          <option value=${tempCategory.categoryId} class="dropdown-item">${tempCategory.name}</option>
                        </c:forEach>
                      </select>
                    <br>
                    <input type="submit" value="Submit" class="btn btn-primary btn-user btn-block">
                    <input type="hidden" name="categoryToDelete" value=${categoryToDelete.categoryId} hidden="true">
                  </form>
              </div>


              <div class="col-sm-6 mb-3 mb-sm-0">
                <b>new category</b><br>
                <form:form action="transferToNewCategory" modelAttribute="category">
                  <div class="form-group">
                    <form:input path="name" cssClass="form-control" placeholder="Category name"/>
                  </div>
                  <div class="form-group">
                    <form:input path="description" cssClass="form-control" placeholder="Description"/>
                  </div>
                  <input type="submit" value="Add" class="btn btn-primary btn-user btn-block"/>
                  <input type="hidden" name="categoryToDelete" value=${categoryToDelete.categoryId} hidden="true">
                </form:form>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <%@include file="../footer.jsp" %>

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <%@include file="../logout-modal.jsp" %>

  <!-- Bootstrap core JavaScript-->
  <script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="../js/sb-admin-2.min.js"></script>

</body>

</html>
