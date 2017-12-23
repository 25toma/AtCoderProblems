# AtCoder Problems

[![Build Status](https://travis-ci.org/kenkoooo/AtCoderProblems.svg?branch=master)](https://travis-ci.org/kenkoooo/AtCoderProblems)
[![codecov](https://codecov.io/gh/kenkoooo/AtCoderProblems/branch/master/graph/badge.svg)](https://codecov.io/gh/kenkoooo/AtCoderProblems)

# Backend API Server

API server application and scrapers are written in Scala.

## Build

```bash
sbt assembly
```

## Test

```bash
sbt test
```

# Frontend Web Application

Frontend web application is written in TypeScript.

## Build

```bash
# install node modules
npm install

# generate js file and source map
webpack

# generate minified js file
npm run build
```

## Test

```bash
npm test
```

# API

## Information API

- Contests Information
  - http://kenkoooo.com/atcoder/atcoder-api/info/contests
- Problems Information
  - http://kenkoooo.com/atcoder/atcoder-api/info/problems
- Detailed Problems Information
  - http://kenkoooo.com/atcoder/atcoder-api/info/merged-problems

## User Information API

- Accepted Count
  - http://kenkoooo.com/atcoder/atcoder-api/info/ac
- Shortest Code Count
  - http://kenkoooo.com/atcoder/atcoder-api/info/short
- Fastest Code Count
  - http://kenkoooo.com/atcoder/atcoder-api/info/fast
- First Accepted Count
  - http://kenkoooo.com/atcoder/atcoder-api/info/first
- Rated Point Sum
  - http://kenkoooo.com/atcoder/atcoder-api/info/sums
- Accepted Count for each langages
  - http://kenkoooo.com/atcoder/atcoder-api/info/lang

## Submission API
  - http://kenkoooo.com/atcoder/atcoder-api/results?user=wata&rivals=iwiwi,chokudai
