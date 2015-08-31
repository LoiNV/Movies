<!-- Banner -->
<div class="banner-top">
    <img alt='top banner' src="images/banners/bra.jpg" >
</div>

<!-- Header section -->
<header class="header-wrapper">
    <div class="container">
        <!-- Logo link-->
        <a href='Home' class="logo">
            <img alt='logo' src="images/logo.png">
        </a>

        <!-- Main website navigation-->
        <nav id="navigation-box">
            <!-- Toggle for mobile menu mode -->
            <a href="#" id="navigation-toggle">
                <span class="menu-icon">
                    <span class="icon-toggle" role="button" aria-label="Toggle Navigation">
                        <span class="lines"></span>
                    </span>
                </span>
            </a>

            <!-- Link navigation -->
            <ul id="navigation">
                <li>
                    <span class="sub-nav-toggle plus"></span>
                    <a href="SearchFilm?sorting=category&&query=Action">Action</a>
                </li>
                <li>
                    <span class="sub-nav-toggle plus"></span>
                    <a href="SearchFilm?sorting=category&&query=Adventure">Adventure</a>

                </li>
                <li>
                    <span class="sub-nav-toggle plus"></span>
                    <a href="SearchFilm?sorting=category&&query=Fantasy">Fantasy</a>

                </li>
                <li>
                    <span class="sub-nav-toggle plus"></span>
                    <a href="SearchFilm?sorting=category&&query=Funny">Funny</a>

                </li>

                <li>
                    <span class="sub-nav-toggle plus"></span>
                    <a href="SearchFilm?sorting=category&&query=Drama">Drama</a>

                </li>

            </ul>
        </nav>

        <!-- Additional header buttons / Auth and direct link to booking-->
        <%
            Boolean b = (Boolean) session.getAttribute("login");
            if (b != null && b) {
        %>
        <div class="control-panel">
            <div class="auth auth--home">
                <div class="auth__show">
                    <span class="auth__image">
                        <img alt="" src="images/client-photo/auth.png">
                    </span>
                </div>
                <a href="#" class="btn btn--sign btn--singin">
                    <%= session.getAttribute("name") %>
                </a>
                <ul class="auth__function">
                    <li><a href="#" class="auth__function-item">Watchlist</a></li>
                    <li><a href="#" class="auth__function-item">Booked tickets</a></li>
                    <li><a href="#" class="auth__function-item">Discussion</a></li>
                    <li><a href="Logout" class="auth__function-item">Log out</a></li>
                </ul>

            </div>
        </div>
        <%
            }else{
        %>
        <div class="control-panel">
            <a href="#" class="btn btn--sign login-window">Sign in</a>            
        </div>
        <%
            }
        %>


    </div>
</header>        

<!-- open/close -->
<div class="overlay overlay-hugeinc">

    <section class="container">

        <div class="col-sm-4 col-sm-offset-4">
            <button type="button" class="overlay-close">Close</button>
            <form class="login" method="post" action="Login?user=user" >
                <p class="login__title">sign in <br><span class="login-edition">welcome to A.Movie</span></p>

                <div class="social social--colored">
                    <a href='#' class="social__variant fa fa-facebook"></a>
                    <a href='#' class="social__variant fa fa-twitter"></a>
                    <a href='#' class="social__variant fa fa-tumblr"></a>
                </div>

                <p class="login__tracker">or</p>

                <div class="field-wrap">
                    <input placeholder='UserName' name="username" class="login__input">
                    <input type="password" placeholder='Password' name="pass" class="login__input">

                    <input type='checkbox' id='#informed' class='login__check styled'>
                    <label for='#informed' class='login__check-info'>remember me</label>
                </div>

                <div class="login__control">
                    <input type="submit" value="sign in" class="btn btn-md btn--warning btn--wider">
                    <a href="#" class="login__tracker form__tracker">Forgot password?</a>
                </div>
            </form>
        </div>

    </section>
</div>