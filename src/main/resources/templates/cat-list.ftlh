<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Exotic Cats Gallery</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .card {
            height: 100%;
        }
        .card-text {
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 3;
            -webkit-box-orient: vertical;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="/cats">🐆 Exotic Cats Gallery</a>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h1>All Exotic Cats</h1>
            <a href="/cats/new" class="btn btn-success">+ Add New Cat</a>
        </div>

        <!-- Search Form -->
        <div class="mb-4">
            <form action="/cats/search" method="get" class="row g-3">
                <div class="col-auto">
                    <input type="text" class="form-control" name="name" placeholder="Search by name..." required>
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
                <div class="col-auto">
                    <a href="/cats" class="btn btn-secondary">Clear</a>
                </div>
            </form>
        </div>

        <#if filterType??>
            <div class="alert alert-info">
                Showing results for <strong>${filterType}</strong>: "${filterValue}"
            </div>
        </#if>

        <!-- Cat Cards -->
        <div class="row">
            <#if catList?has_content>
                <#list catList as cat>
                    <div class="col-md-4 mb-4">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title">${cat.name}</h5>
                                <h6 class="card-subtitle mb-2 text-muted">${cat.breed}</h6>
                                <p class="card-text">${cat.description}</p>
                                <div class="d-flex gap-2">
                                    <a href="/cats/${cat.exoticCatId}" class="btn btn-primary btn-sm">View Details</a>
                                    <a href="/cats/update/${cat.exoticCatId}" class="btn btn-warning btn-sm">Edit</a>
                                    <a href="/cats/delete/${cat.exoticCatId}" 
                                       class="btn btn-danger btn-sm"
                                       onclick="return confirm('Are you sure you want to delete ${cat.name}?')">
                                        Delete
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>
            <#else>
                <div class="col-12">
                    <div class="alert alert-warning">
                        No cats found. <a href="/cats/new">Add your first cat!</a>
                    </div>
                </div>
            </#if>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>