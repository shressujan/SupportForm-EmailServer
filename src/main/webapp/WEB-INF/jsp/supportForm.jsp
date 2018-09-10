<!DOCTYPE html>
<html>
<head>
  <title>Support Form</title>
  <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
</head>
<body>
<header class="jumbotron container text-center"><h1>Support Form</h1></header>
<form method="post" enctype="multipart/form-data">
  <div class="container">
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="name">Name</label>
        <input type="text" name="name" class="form-control" id="name" placeholder="Your name">
      </div>
      <div class="form-group col-md-6">
        <label for="contact">Contact</label>
        <input type="text" name="contact" class="form-control" id="contact" placeholder="Your contact info">
      </div>
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input type="text" name="email" class="form-control" id="email" placeholder="Your full email address">
    </div>
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="position">Position</label>
        <input type="text" name="position" class="form-control" id="position" placeholder="Developer, Manager, etc">
      </div>
      <div class="form-group col-md-6">
        <label for="department">Department</label>
        <input type="text" name="department" class="form-control" id="department" placeholder="Admins, Developers, etc">
      </div>
    </div>
    <div class="form-group">
      <label for="location">Location</label>
      <input type="text" name="location" class="form-control" id="location" placeholder="Building name">
    </div>
    <div class="form-row">
      <div class="form-group col-md-6">
        <label for="room-number">Room-Number</label>
        <input type="text" name="roomNumber" class="form-control" id="room-number" placeholder="A126, B134....">
      </div>
    </div>
    <div class="form-group">
      <label for="message">Type your Issue</label>
      <textarea type="message" name="message" class="form-control" id="message" rows="5" placeholder="Type what issue you are having!"></textarea>
    </div>
    <div class="form-group">
      <label for="file">Attachment</label>
      <input type="file" name="file" class="form-control-file" id="file">
    </div>
    <div class="form-group">
      <div class="form-check">
        <input class="form-check-input" name="urgent" type="radio" id="urgent" value="true">
        <label class="form-check-label" for="urgent">
          Urgent
        </label>
      </div>
    </div>
    <div class="form-group">
      <div class="form-check">
        <input class="form-check-input" name="urgent" type="radio" id="notUrgent" value="false">
        <label class="form-check-label" for="notUrgent">
          Not Urgent
        </label>
      </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</form>
</body>
</html>