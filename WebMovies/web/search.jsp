<!-- Search bar -->
<div class="search-wrapper">
    <div class="container container--add">
        <form action="SearchFilm" method='get' class="search">
            <input type="text" name="query" class="search__field" placeholder="Search">
            <select name="sorting" id="search-sort" class="search__sort" tabindex="0">
                <option value="category" selected='selected'>By Category</option>
                <option value="name">By Name</option>
            </select>
            <button type='submit' class="btn btn-md btn--danger search__button">search a movie</button>
        </form>
    </div>
</div>

