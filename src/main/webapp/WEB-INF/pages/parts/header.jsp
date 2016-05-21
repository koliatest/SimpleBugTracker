<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">Bugtracker</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/user">${currentUser.firstName} ${currentUser.lastName}</a></li>
      </ul>

      <ul class="nav navbar-nav navbar-right">
        <sec:authorize access="hasRole('ROLE_ADMIN')">
          <li><a href="#">Admin page</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
          <li><a href="/profile">Profile</a></li>
        </sec:authorize>
        <li><a href="/about">About</a></li>
        <sec:authorize access="isAuthenticated()">
          <li><a href="/auth/logout">Logout</a></li>
        </sec:authorize>
      </ul>
    </div><!--/.navbar-collapse -->
  </div>
</nav>