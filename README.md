# backend-coding-challenge
## Technical specs

A REST microservice based on spring boot. 

## Functional specs

- Develop a REST microservice that list the languages used by the 100 trending public repos on GitHub.
- For every language, you need to calculate the attributes below 👇:
    - Number of repos using this language
    - The list of repos using the language

## How to get Trending Repos from Github

Fetching trending repositories simply translates to fetching the most starred repos created in the last 30 days ( from now ). To do that, you'll need to call the following endpoint:

```
https://api.github.com/search/repositories?q=created:>{date}&sort=stars&order=desc
```

The JSON data from Github will be paginated (you'll receive around 100 repos per JSON page). You can ignore the subsequent pages since you only need the first 100 repositories.

If you want to learn more about the Github API, you can click on the following [link](https://developer.github.com/v3/).