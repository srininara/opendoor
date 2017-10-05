alter TABLE feedback
  add column upvotes int DEFAULT 0,
  add column downvotes int DEFAULT 0;
