<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${cat.name} - Exotic Cat Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .detail-card {
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
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
        <!-- SUCCESS MESSAGE ALERT -->
        <#if successMessage??>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Success!</strong> ${successMessage}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </#if>
        
        <!-- ERROR MESSAGE ALERT -->
        <#if errorMessage??>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>Error!</strong> ${errorMessage}
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </#if>

        <div class="card detail-card">
            <div class="card-header bg-primary text-white">
                <h1 class="mb-0">${cat.name}</h1>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-6">
                        <h5>Basic Information</h5>
                        <table class="table table-bordered">
                            <tr>
                                <th>ID</th>
                                <td>${cat.exoticCatId}</td>
                            </tr>
                            <tr>
                                <th>Breed</th>
                                <td>${cat.breed}</td>
                            </tr>
                            <tr>
                                <th>Origin</th>
                                <td>${cat.origin}</td>
                            </tr>
                            <tr>
                                <th>Size</th>
                                <td>${cat.size}</td>
                            </tr>
                            <tr>
                                <th>Lifespan</th>
                                <td>${cat.lifespan}</td>
                            </tr>
                            <tr>
                                <th>Conservation Status</th>
                                <td>${cat.conservationStatus!""}</td>
                            </tr>
                        </table>
                    </div>
                    
                    <div class="col-md-6">
                        <h5>Description</h5>
                        <p>${cat.description}</p>
                        
                        <h5 class="mt-4">Care Requirements</h5>
                        <p>${cat.careRequirements!""}</p>
                    </div>
                </div>
            </div>
            
            <div class="card-footer">
                <div class="d-flex gap-2">
                    <a href="/cats" class="btn btn-secondary">
                        ← Back to List
                    </a>
                    <a href="/cats/update/${cat.exoticCatId}" class="btn btn-warning">
                        ✏️ Edit
                    </a>
                    <a href="/cats/delete/${cat.exoticCatId}" 
                       class="btn btn-danger"
                       onclick="return confirm('Are you sure you want to delete ${cat.name}?')">
                        🗑️ Delete
                    </a>
                </div>
            </div>
        </div>

        <div class="mt-4">
            <h4>View More Cats</h4>
            <a href="/cats/breed/${cat.breed}" class="btn btn-outline-primary">
                View all ${cat.breed} cats
            </a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>